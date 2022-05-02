package com.myspring.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myspring.domain.MemberVO;
import com.myspring.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	// 서비스는 dao, 컨트롤러의 중간단계이므로, dao객체가 필요하다.
	@Inject
	private MemberDAO dao;
	

	@Override
	public String getTimeS() {
		String time = dao.getTime();	// DAO의 메서드 호출.
		return time;
	}


	// 회원가입
	@Override
	public void insertMember(MemberVO vo) {
		log.info("서비스 - 회원가입DAO호출!!");
		dao.insertMember(vo);
		
	}
	
	
	
	
}
