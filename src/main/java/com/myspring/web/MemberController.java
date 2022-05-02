package com.myspring.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.domain.MemberVO;
import com.myspring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/dbTime", method=RequestMethod.GET)
	public void timeCall(Model model) {
		// DB의 시간정보를 가져와서 view에 출력하기. 
		String time = service.getTimeS(); 
		model.addAttribute("time", time); 
	}
	
	
	// 회원가입(get) : http://localhost:8088/member/login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String insertGet() {
		return "/member/login";
	}
	
	// 회원가입(post)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void insertPOST(MemberVO vo) {	
		// 전달된 데이터 저장: 메서드 전달인자로 VO를 써주면 파라미터를 자동으로 받는다.
		log.info("회원가입 받은 값: " + vo.toString());
	
		// 회원가입 동작 호출(서비스)
		service.insertMember(vo);
		// 페이지 이동
		
	}
	

}
