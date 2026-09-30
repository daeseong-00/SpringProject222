package com.mnu.sample.dto;

import com.mnu.sample.entity.DeptEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor  // 파라미터가 없는 생성자 생성
@Getter
public class DeptRequestDTO {
	private int dno;
	private String dname;
	private String loc;

	//DTO에서 필요한 부분을 Entity화
	//빌더패턴
	public DeptEntity toEntity() {
		return DeptEntity.builder()
				.dno(dno)
				.dname(dname)
				.loc(loc)
				.build();
	}
}
