package sj.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import sj.deploy.OrderStatus;

@Builder
@Getter
@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id @GeneratedValue @Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne @JoinColumn(name="MEMBER_ID")
	private Member member;
	
	//양방향관계이면서 owner가 아닌 경우 mappedBy를 통해 명시해준다. (owner는 @JoinColumn()으로 명시)
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@OneToOne @JoinColumn(name="DELIVERY_ID")
	private Delivery delivery;
	
	/* @Temporal
	 * java 8의 LocalDate(date), LocalDateTime(timestamp) 을 사용할 때는 생략이 가능하다.
		hibernate에서 지원
		private LocalDate createDate  , private LocalDateTime createDateTime;
	 */
	
	private LocalDate orderDate; 
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	//양방향 연관관계에 대해서는 연관관계 편의 메소드를 작성하여 관리하는 것이 편리하다!
	
	//양방향관계 member(1)<-> order(*), orderItem(*)<->order(1), Delivery(1)->order(1)
	
	public void setMember(Member member) {
		
		
		/*기존의 member1 - order 관계가 제거 되지 않아도 db에서 외래키 변경하는건 문제없음
		 *관계의 owner는 Order임 (Fk를 가지는애가 Order임)
		 *
		 *member1->Order1  ==>  member2->Order2
		 *setMember()만 해줘도 Order.getMember() 했을때 변경된 member2를 참조할 수 있다.
		 *
		 *그런데 member1.Order하면 아직도 Order1이 참조되는거아닌가?!
		 *==> member1.gerOrders()를 호출하면 영속성 컨텍스트의 1차캐시내에 있는 member1을 조회하고 메서드 호출하여 
		 *DB를 조회한다. 이때 DB내의 order의 memberFK는 이미 member2 의 id로 바뀌었으므로 조회되지 않는다.
		 * 
		 * 하지만! 관계를 변경한뒤 영속성 컨텍스트가 살아있는 상태에서는 (아직 flush() 하지 않은경우//commit 시에 flush일어남 (변경상태 db에 반영)
		 *  에는 member1이 참조됨
		 * 따라서 연관관계 변경시에는 관계를 제거하는것이 안전하다. 
		 * 
		 * 요약 : 연관관계 변경시 db에 변경상태 반영전에 (flush()전에) 조회하면 변경전의 관계가 참조됨 제거해주는 것이 안전!!
		 */
		
		//1. 기존에 있던 멤버가 있었다면 -> member가 order를 바라보는 관계를 삭제
			if(this.member!=null) {
				this.member.getOrders().remove(this);
			}
		//2. member셋팅
			this.member=member;
		//3. member에 가서 Order셋팅
			member.getOrders().add(this);
		
	}
	
	public void setDelivery(Delivery delivery) {
		//OneToOne이고 delivery 에서 참조할 수 있는 Order는 하나이므로 관계 변경시 기존관계 저절로 제거
		this.delivery = delivery;
		delivery.setOrder(this);
	}
	
	public void addOrderItems(OrderItem orderItem) {
		//this의 OrderList에 OrderItem추가
		this.orderItems.add(orderItem);
		
		//OrderItem에 this추가
		orderItem.setOrder(this);
	}
	
	
	
	
}
