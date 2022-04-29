package com.myspring.persistence;

import com.myspring.*;
import com.myspring.domain.MemberVO;

public interface MemberDAO {
	// 필요한 동작을 추상메서드 형태로 구현.
	// DB서버의 시간 정보 확인
	// @Select("select now()") // 메서드에 어노테이션붙이는 2번 방법
	public String getTime();

	// 회원가입 동작
	public void insertMember(MemberVO vo);
	

	// 로그인 체크 동작
	// public void loginMember(String userid, String userpw); -> 이건 비추.
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String userid, String userpw);	// 오버로딩
}
