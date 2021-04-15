package sj.test.idclass;

import java.io.Serializable;

public class ParentId implements Serializable{

	private Integer id1;
	private Integer id2;
	
	public ParentId() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 이렇게 식별자 클래스를 만들게 되면 JPa에서 persistent Context에 저장하기 직전에
	 * Parent.id1 , Parent.id2값을 가져와서 ParentId를 생성하고 이 ParentId를 영속성 컨텍스트의 키로 사용한다.
	 */
	
	/*
	 * 자바의 모든 클래스는 기본적으로 Object를 상속받음
	 * Object 에서의 equals메서드는 동일성 비교 (==비교) 를 함으로 
	 * 적절히 오버로딩 하지 않은 경우에 ==비교가 실행됨
	 * 
	 * 영속성 컨텍스트는 식별자클래스를 키로 사용하여 엔티티를 관리
	 */
	
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
