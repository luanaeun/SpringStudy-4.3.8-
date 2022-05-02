package com.myspring.service;

import com.myspring.domain.MemberVO;

// 컨트롤러와 DAO를 연결하는 다리역할.
// 이 다리도 서브클래스로 직접 생성하는게 아니라 다리도 인터페이스를 구현하는 상속을 통해서 표현할 것이다. 
public interface MemberService {
	// DAO 동작을 호출하는 추상메서드를 선언. 
	
	// 시간정보를 가져오는 동작
	public String getTimeS();
	
	// 회원가입
	public void insertMember(MemberVO vo);
}
