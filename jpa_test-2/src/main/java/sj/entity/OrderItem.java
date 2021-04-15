package sj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name="ORDER_ITEM")
@Entity
public class OrderItem {
	/*
	 * 	다대다의 경우 외부키를 기본키로 사용하는 경우 
	 * 1.@JoinTable 사용하면 JPA가 알아서 연결테이블을 처리해줌
		하지만 새로운 필드를 추가할 수 없다.
		새로운 필드를 추가하는 경우 
		2. 식별클래스를 생성하고 @IdClass(식별클래스) 해야함   find(클래스, 식별클래스) 를 통해 참조가능
		3. 1,2 할필요없이 그냥 새로운 기본키 생성!  (다 : 다 를 1:다 다:1 로 매핑하는것을 권장)
	 */
	@Id @GeneratedValue @Column(name="ORDER_ITEM_ID")
	private Long id;

	@ManyToOne @JoinColumn(name="ORDER_ID")
	private Order order;
	
	@ManyToOne @JoinColumn(name="ITEM_ID")
	private Item item;
	
	@Column(name="ORDER_PRICE")
	private Integer orderPrice;
	
	@Column(name="ITEM_COUNT")
	private Integer itemCount;
	
	
	
	public void setOrder(Order order) {
		this.order = order;
		if(!order.getOrderItems().contains(this)) {
		order.getOrderItems().add(this);
		}
		//현재 로직은
		/*<Order에서 실행시>
		 * 1. Order의 List에 OrderItem추가
		 * 2. OrderItem의 setOrder 메서드 호출하여 OrderItem에도 Order를 추가
		 *     2-1. setOrder를 호출
		 *     2-2. order를 OrderItem에 셋팅한다
		 *     2-3. 셋팅한 order의 OrderItem을 호출하여 다시 orderItem추가
		 * 즉 1 과 2-3에서 동일한 작업이 2번수행됨...
		 * 
		 * 
		 * 
		 * 양방햔 관계이므로 양쪽에서 관리할 수 있게 메서드를 양측에 써주니까 이런문제가 발생함...
		 * ==> 조건 추가! 1에서 이미 list에 this가 추가 되었다면 2-3 은 실행되지 않도록!!
		 * 
		 * 
		 */
	}
	
	public void setItem(Item item) {
		
		this.item= item;
		if(!item.getOrderItems().contains(this)) {
			item.getOrderItems().add(this);
		}
	
		
	}

	

}
