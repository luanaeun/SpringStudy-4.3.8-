package com.myspring.persistence;

import com.myspring.persistence.MemberDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	
	
	@Override
	public String getTime() {
		System.out.println("DAO: 시간정보 확인 메서드");
		//sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		String time = sqlSession.selectOne(NAMESPACE + ".getTime");
		
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


	// 로그인 두가지 방법
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

	
	// 회원 정보 가져오기
	@Override
	public MemberVO getMemberInfo(String id) {
		System.out.println("DAO: 회원정보 가져오기.");
		MemberVO vo = sqlSession.selectOne(NAMESPACE + ".getMemberInfo", id);
		log.info("DAO: 회원정보결과: " + vo.toString());
		return vo;
	}

	
	// 회원정보 수정
	@Override
	public Integer updateMemberInfo(MemberVO vo) {
		System.out.println("DAO: 회원정보 수정하기.");
		Integer result = sqlSession.update(NAMESPACE + ".modifyMemberInfo", vo);
		log.info("회원정보 수정완료: " + result);
		return result;
	}

	
	// 회원 삭제
	@Override
	public void deleteMember(MemberVO vo) {
		log.info("DAO: 회원정보 삭제");
		sqlSession.delete(NAMESPACE + ".deleteMember", vo);
	}

	
	// 회원 전체 리스트
	@Override
	public List<MemberVO> getMemberList() {
		// selectList는 받아오는 VO객체를 알아서 차곡차곡 리스트형태로 만들어준다.
		List<MemberVO> memberList = sqlSession.selectList(NAMESPACE + ".memberList");
		return memberList;
	}
	
	
	
	

}