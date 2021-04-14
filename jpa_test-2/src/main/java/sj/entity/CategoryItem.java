package sj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class CategoryItem {

	@Id @GeneratedValue @Column(name="CATEGORY_ITEM_ID")
	private Long id;
	
	@ManyToOne @JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	@ManyToOne @JoinColumn(name="ITEM_ID")
	private Item item;
	
	public void setCategory(Category category) {
		this.category=category;
		if (!category.getCategoryItems().contains(this)) {
			category.getCategoryItems().add(this);
		}
	}
	
	public void setItem(Item item) {
		this.item = item;
		if (!category.getCategoryItems().contains(this)) {
			category.getCategoryItems().add(this);
		}
	
	}
	
}
