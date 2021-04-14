package sj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Table(name="member")
@Entity
public class Member {
	
	@Id @GeneratedValue @Column(name="MEMBER_ID")
	private String id;
	
	private String username;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
	
	
	
}
