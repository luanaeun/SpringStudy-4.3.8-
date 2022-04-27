package com.myspring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.domain.ProductVO;


@Controller
public class SampleController01 {
	private static final Logger log = LoggerFactory.getLogger(SampleController01.class);
	
	
	// 기본 페이지 연결 연습. 
	// http://localhost:8088/web/doTest
	@RequestMapping("/doTest")
	public void doTest() {
		System.out.println("@@@ doTest로 이동!");
		log.info("@@@ 로그 출력 @@@");
		log.debug("디버그 - doTest");
	}
	
	
	// get으로 파라미터 값 보내기 연습.
	// http://localhost:8088/web/doTest?msg="yayaya"
	@RequestMapping("/doTest02")
	public String doTest02(@ModelAttribute("msg") String msg) {
		log.info("@@@ 로그 출력 -> doTest02실행 @@@");
		
		return "parameterTest";
	}
	
	
	// 데이터 여러개 보내기 연습(객체 사용). 
	@RequestMapping("/doProductD")
	public String doProductD(
			@ModelAttribute("data") String data,
			Model model
	) {
		log.info("/doProductD 주소 호출 -> productDetail");
		
		// 나중에는 여기 DB에서 받아온 정보가 들어감.
		ProductVO vo = new ProductVO("컴퓨터", 100);
		model.addAttribute("vo", vo);
		model.addAttribute(vo);		//이렇게 이름없이 전달하면 어떻게 될까??
		
		return "productDetail";
	}
	
	
	// 리다이렉트 연습 - doA를 호출하면 바로 doB주소가 열린다. 
//	@RequestMapping("/doA")
//	public String doA(@ModelAttribute("data") String data) {
//		return "redirect:/doB";
//	}
//	@RequestMapping("/doB")
//	public void doB(@ModelAttribute("data") String data) {
//	}
	// 이 방법은 페이지가 이동하고 나서도 데이터가 계속유지된다. 한번만 쓸려면 어떻게 해야할까?
	@RequestMapping("/doA")
	public String doA(RedirectAttributes rttr) {
		rttr.addFlashAttribute("data", "1회성데이터");	// 1회성 데이터 전달. 
		return "redirect:/doB";
	}
	@RequestMapping("/doB")
	public void doB(@ModelAttribute("data") String data) {
		log.info("doB에서 받은 데이터: " + data);
	}
}





