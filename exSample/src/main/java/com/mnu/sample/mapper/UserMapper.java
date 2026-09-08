package com.mnu.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	//1. id 중복 검사
	public int userIdCheck(String userid);
	
	
}
