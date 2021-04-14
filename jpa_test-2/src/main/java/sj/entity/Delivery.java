package sj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import sj.deploy.DeliveryStatus;


@Builder
@Getter
@Table(name="DELIVERY")
@Entity
public class Delivery {

	
	@Id @GeneratedValue @Column(name="DELIVERY_ID")
	private Long id;
	
	// Order(1)->Delivery(1) 로 Order가 Delivery의 fk관리 
	//원래는 대상에 fk를 두는게 나음 나중에 1대 다로 바뀌더라도 코드 수정할 필요없음
	@OneToOne(mappedBy = "delivery")
	private Order order;
	
	
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	public void setOrder(Order order) {
		// setOrder와 setDelivery 무한루프 -> 
		this.order=order;
		if(order.getDelivery()!=this) {
			order.setDelivery(this);
		}

	}
	
	
}
