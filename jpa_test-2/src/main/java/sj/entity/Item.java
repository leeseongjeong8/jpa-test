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
@Entity
@Table(name="ITEM")
public class Item {

	@Id @GeneratedValue @Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	
	private Integer price;
	
	private Integer stockQuantity;
	
	//카테고리(1) <->카테고리_아이템(*) <-> 아이템 (1)
	@OneToMany(mappedBy = "item")
	private List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
	
	@OneToMany(mappedBy = "item")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public void addCategoryItem(CategoryItem categoryItem) {
		
		this.getCategoryItems().add(categoryItem);
		
		categoryItem.setItem(this);
		
	}
	
	public void addOrderItem(OrderItem orderItem) {
		
		this.getOrderItems().add(orderItem);
		
		orderItem.setItem(this);
		
	}
	
}
