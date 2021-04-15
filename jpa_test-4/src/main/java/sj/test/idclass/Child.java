package sj.test.idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {

	@Id @GeneratedValue @Column(name="CHILD_ID")
	private Integer id;
	
	@ManyToOne @JoinColumns({
		@JoinColumn(name="PARENT_ID1"),@JoinColumn(name="PARENT_ID2")
	})
	private Parent parent;
	
}