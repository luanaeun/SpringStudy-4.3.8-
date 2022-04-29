package com.myspring.persistence;

import com.myspring.persistence.MemberDAO;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.domain.MemberVO;

//이 골뱅이는 이 클래스가 DAO역할을 하는 객체로 스프링이 인식하게 한다. 
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// DB연결과 자원해제.
	@Inject
	private SqlSession sqlSession;
	
	// sql구문이 저장되어있는 mapper의 주소
	private static final String NAMESPACE = "com.myspring.mapper.MemberMapper";
	
	
	@Override
	public String getTime() {
		System.out.println("DAO: 시간정보 확인 메서드");
		//sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		String time = sqlSession.selectOne(NAMESPACE + ".gettime");
		
		return time;
	}
	
	
	@Override
	public void insertMember(MemberVO vo) {
		System.out.println("DAO: insertMember(vo)실행");
		
		System.out.println("DAO: 연결되어있는 mapper 호출");
		// dao객체에 있는 insert구문 실행 -> mapper에 선언해놓은 sql구문과 연결.
		sqlSession.insert(NAMESPACE + ".memberJoin", vo);
		
		System.out.println("DAO: 회원가입 완료!");
	}


	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("DAO: loginMember(vo)실행");
		MemberVO voTemp = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		System.out.println("DAO: 로그인 완료!");
		
		return voTemp;
	}
	
	@Override
	public MemberVO loginMember(String userid, String userpw) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		MemberVO voTemp = sqlSession.selectOne(NAMESPACE + ".loginMember", paramMap);
		
		return voTemp;
	}

	

}