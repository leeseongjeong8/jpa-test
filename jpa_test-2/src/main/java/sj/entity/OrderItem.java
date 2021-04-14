package sj.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="ORDER_ITEM")
@Entity
public class OrderItem {

	
	@ManyToOne @JoinColumn(name="ORDER_ID")
	private Order order;
}
