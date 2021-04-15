package sj.test.embeddedclass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParentId2 implements Serializable{
	
	/*
	 * IdClass는 좀더 데이터베이스 중심
	 * EmbeddedId는 좀더 객체지향 중심
	 */
	
	@Column(name="PARENT_ID1")
	private Integer id1;
	
	@Column(name="PARENT_ID2")
	private Integer id2;
	
	public ParentId2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
