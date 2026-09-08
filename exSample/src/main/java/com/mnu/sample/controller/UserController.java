package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnu.sample.service.UserService;

@Controller
@RequestMapping("User")
public class UserController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);

	//UserService 주입
	@Autowired
	private UserService userService;
	
	//로그인 폼
	@GetMapping("user_login")
	public String userLogin() {
		log.info("User Call : login");
		
		return "User/user_login";
	}
	
	//로그아웃 처리
	@GetMapping("user_logout")
	public String userLogout() {
		log.info("User Call : logout");
		
		return "redirect:";//index로 이동
	}
		
	//회원가입 폼
	@GetMapping("user_insert")
	public String userInsert() {
		log.info("User Call : userInsert");
		
		return "User/user_insert";
	}
	
	//ID 중복검사
	@ResponseBody
	@PostMapping("user_idCheck")
	public String userIdCheck(@RequestParam("userid") String userid) {
		log.info("User Call : user_idCheck");
		int row = userService.userIdCheck(userid);
		return String.valueOf(row);
	}
	
	
	//보인인증(SMS)
	
	
	//보인인증(email)
	
	//회원가입처리
	
	
	//정보수정 폼
	@GetMapping("user_modify")
	public String userModify() {
		log.info("User Call : userModify");
		
		return "User/user_modify";
	}

	//정보수정 처리
	
	//회원탈퇴(삭제)
	
	//ID찾기 폼
	
	
	//비번분실시 id 입력 폼
	
	
	//비번분실시 id를 찾어서 임시비번 발송

}
