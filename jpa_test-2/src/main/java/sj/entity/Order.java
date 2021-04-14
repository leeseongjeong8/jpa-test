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

import sj.deploy.OrderStatus;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id @GeneratedValue @Column(name="ORDER_ID")
	private Integer id;
	
	@ManyToOne @JoinColumn(name="MEMBER_ID")
	private Member member;
	
	//양방향관계이면서 owner가 아닌 경우 mappedBy를 통해 명시해준다. (owner는 @JoinColumn()으로 명시)
	@OneToMany(mappedBy = "order")
	private List<Order> orderItems = new ArrayList<>();
	
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
	
	//양방향관계 member<-> order, orderItem<->order, Delivery<->order
	
	
	
	
}
