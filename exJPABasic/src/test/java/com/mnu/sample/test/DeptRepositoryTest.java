package com.mnu.sample.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mnu.sample.dto.DeptResponseDTO;
import com.mnu.sample.entity.DeptEntity;
import com.mnu.sample.repository.DeptRepository;

@SpringBootTest
@ActiveProfiles("test")//(application-test.yml) h2db을 이용한 테스트 일 경우
public class DeptRepositoryTest {
	//DeptRepository 주입
	@Autowired
	private DeptRepository deptRepository;
	
	//등록 테스트
	@Test
	public void insertDeptTest() {
		DeptEntity entity = DeptEntity.builder()
				.dno(1)
				.dname("총무과")
				.loc("목포")
				.build();
		DeptEntity dept = deptRepository.save(entity);
		DeptResponseDTO resDTO = new DeptResponseDTO(entity);
		System.out.println("등록된 부서명 : " + resDTO.getDno());
	}
	
	
	
}
