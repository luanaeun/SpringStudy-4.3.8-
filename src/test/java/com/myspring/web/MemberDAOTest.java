package com.myspring.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myspring.persistence.MemberDAO;
import com.myspring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class MemberDAOTest {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void 회원가입하기() {
		System.out.println("Test: 회원가입 실행");
		// 회원정보 생성
		MemberVO vo = new MemberVO();
		vo.setUserid("user1");
		vo.setUserpw("1234");
		vo.setUsername("user1");
		vo.setEmail("user1@user1.com");
		
		dao.insertMember(vo);
	}
	
	// @Test
	public void 로그인체크() {
		System.out.println("Test: 로그인 체크 테스트");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("12345555");
		MemberVO voTemp = dao.loginMember(vo);
		
		if(voTemp != null) {
			System.out.println("Test: 회원이 있음");
		} else {
			System.out.println("Test: 비회원");
		}
	}
	
	// @Test
	public void 회원정보조회() {
		System.out.println("Test: 회원정보 조회 테스트");
		String userid = "admin";
		MemberVO vo = dao.getMemberInfo(userid);
		System.out.println("Test: 회원정보결과: " + vo.toString());
	}
	
	// @Test
	public void 회원정보수정() {
		System.out.println("Test: 회원정보 수정 테스트");
		MemberVO updateVO = new MemberVO();
		updateVO.setUserid("admin");
		updateVO.setUserpw("1234");
		updateVO.setUsername("수정 관리자");
		updateVO.setEmail("updateAdmin@admin.com");
		
		Integer result = dao.updateMemberInfo(updateVO);
		System.out.println("Test: 회원정보 수정 완료=> " + result);
	}
	
//	@Test
	public void 회원정보삭제() {
		MemberVO delVO = new MemberVO();
		delVO.setUserid("user1");
		delVO.setUserpw("1234");
		
		dao.deleteMember(delVO);
		System.out.println("Test: 회원정보 삭제 완료");
	}
	
//	@Test
	public void 회원전체목록() {
		List<MemberVO> memberList = dao.getMemberList();
		log.info("회원전체목록 결과: " + memberList);
	}
	
}
