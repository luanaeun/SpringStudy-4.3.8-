package com.myspring.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myspring.persistence.MemberDAO;
import com.myspring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	@Inject
	private MemberDAO dao;
	
	@Test
	public void 회원가입하기() {
		System.out.println("Test: 회원가입 실행");
		// 회원정보 생성
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setEmail("admin@admin.com");
		
		dao.insertMember(vo);
		
	}
}
