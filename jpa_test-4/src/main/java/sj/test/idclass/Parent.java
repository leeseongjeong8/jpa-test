package sj.test.idclass;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import sj.test.embeddedclass.ParentId2;

@IdClass(ParentId.class)
@Entity
public class Parent {

	@Id @Column(name="PARENT_ID1")
	private Integer id1;
	
	@Id @Column(name="PARENT_ID2")
	private Integer id2;
	
//	@EmbeddedId
//	private ParentId2 id;
	
	/*
	 * 식별키가 2개인 경우에는 식별자 클래스를 별도로 만들어야 한다.
	 * 
	 * JPA가 persistentContext에 엔티티를 보관할때 식별자를 키로 사용한다. 
	 * 이때 식별자를 구분하기 위해 hashcode와 equals 메서드를 사용하여 동등성비교를 함.
	 * 
	 * 식별자가 하나이면 문제없지만
	 * 식별자 필드가 2개이상이면 식별자 클래스를 만들고 그곳에 equals와 hashCode메서드를 구현해야 한다.
	 * 
	 * 1) EmbeddedId 2) IdClass
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
}
