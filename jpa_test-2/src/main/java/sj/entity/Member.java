package sj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;


@Getter
@Table(name="member")
@Entity
public class Member {
	
	@Id @GeneratedValue @Column(name="MEMBER_ID")
	private Long id;
	
	@Column(name="USER_NAME")
	private String username;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();
	
	public void addOrder(Order order) {
		this.orders.add(order);
		
		order.setMember(this);
	}
	
}
