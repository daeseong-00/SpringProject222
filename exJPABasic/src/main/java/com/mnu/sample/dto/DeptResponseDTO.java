package com.mnu.sample.dto;

import com.mnu.sample.entity.DeptEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor  // 파라미터가 없는 생성자 생성
@Getter
public class DeptResponseDTO {
	private int dno;
	private String dname;
	private String loc;
	
	public DeptResponseDTO(DeptEntity entity) {
		this.dno=entity.getDno();
		this.dname=entity.getDname();
		this.loc=entity.getLoc();
	}

}

