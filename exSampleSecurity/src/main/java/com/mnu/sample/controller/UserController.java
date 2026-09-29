package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);

	//로그인 폼
	@GetMapping("/Join/user_login")
	public String userLogin() {
		log.info("User Call : user_login");
		return "/Join/user_login";
	}
	
	//로그인 에러(id, pass 오류시)
	@GetMapping("/Join/user_error")
	public String userLoginError() {
		log.info("User Call : user_login_error");
		return "/Join/user_error";
	}

	//회원가입 폼
	@GetMapping("/Join/user_insert")
	public String userInsert() {
		log.info("User Call : user_insert");
		return "/Join/user_insert";
	}
	
	//ID 중복 검사
	
	//인증
	
	
	//회원 가입처리(DB 저장)
	
	//MyPage
	@GetMapping("/User/user_mypage")
	public String userMyPage() {
		log.info("User Call : user_mypage");
		return "/User/user_mypage";
	}

	
}
