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
