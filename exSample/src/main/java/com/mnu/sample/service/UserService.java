package com.mnu.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnu.sample.mapper.UserMapper;

@Service
public class UserService {
	//UserMapper 주입
	@Autowired
	private UserMapper userMapper;

	//1. id 중복 검사
	public int userIdCheck(String userid) {
		return userMapper.userIdCheck(userid);
	}
}
