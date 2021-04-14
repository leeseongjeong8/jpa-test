package sj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Category {

	@Id @GeneratedValue @Column(name="CATEGORY_ID")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
	
	/*
	 * Category에는 1차카테고리 2차카테고리가 있음 (계층구조)
		1차 카테고리<Category> : 식품 -> 2차 카테고리 - 계란,생선... 등 카테고리들의 리스트 List<Category>
		parent가 있으면 하위키 없으면 상위키임   
		<self referencing>
		본인키 4 parent key1 => 1번카테고리에 속한 4번 카테고리  
		본인키 4 parent key null =>  1차카테고리인 4번 카테고리임
	 */
	
	@Column(name="PARENT_ID")
	private Long parentId;
	
	public void addCategoryItems(CategoryItem categoryItem) {
		
		this.getCategoryItems().add(categoryItem);
		
		categoryItem.setCategory(this);
		
	}
	
	
	
	
}
