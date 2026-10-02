package com.mnu.sample.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mnu.sample.dto.DeptResponseDTO;
import com.mnu.sample.entity.DeptEntity;
import com.mnu.sample.repository.DeptRepository;



@SpringBootTest
//@ActiveProfiles("test")//(application-test.yml) h2db을 이용한 테스트 일 경우
public class DeptRepositoryTest {
	//DeptRepository 주입
	@Autowired
	private DeptRepository deptRepository;
/*	
	//등록 테스트
	@Test
	public void insertDeptTest() {
		DeptEntity entity = DeptEntity.builder()
				.dno(100)
				.dname("총무과")
				.loc("목포")
				.build();
		DeptEntity dept = deptRepository.save(entity);
		DeptResponseDTO resDTO = new DeptResponseDTO(entity);
		System.out.println("등록된 부서명 : " + resDTO.getDno());
	}
	
	//dno 이용한 검색
	@Test
	public void dnoSearchTest() {
		
		DeptEntity entity = deptRepository.findById(20)
				.orElseThrow(()->new IllegalArgumentException("dno 없음"));
		DeptResponseDTO resDTO = new DeptResponseDTO(entity);
		System.out.println("검색된 부서명 : " + resDTO.getDname());
	}
	
	//전체 검색
	@Test
	public void findAllTest() {
		//List<DeptEntity> dList = deptRepository.findAll();//id 오름차순
		//특정 항목을 이용한 오름, 내림차순
		List<DeptEntity> dList = deptRepository.findAll(Sort.by(Sort.Direction.DESC,"dno"));
		
		for(DeptEntity entity : dList) {
			DeptResponseDTO dto = new DeptResponseDTO(entity);
			System.out.print(dto.getDno() + "  ");
			System.out.print(dto.getDname() + "  ");
			System.out.println(dto.getLoc());
			
		}
	}
	
	// 기본키를 이용한 삭제
	@Test
	public void delete() {
		DeptEntity entity = deptRepository.findById(100)
				.orElseThrow(()->new IllegalArgumentException("등록된 id 없음"));
		deptRepository.delete(entity);
		
		// deptRepository.deleteById(100); //바로 삭제
		findAllTest();
	}
	
	//지역명 검색
	@Test
	public void findByLocTest() {
		List<DeptEntity> dList = deptRepository.findByLoc("목포");
		
		for(DeptEntity entity : dList) {
			DeptResponseDTO dto = new DeptResponseDTO(entity);
			System.out.print(dto.getDno() + "  ");
			System.out.print(dto.getDname() + "  ");
			System.out.println(dto.getLoc());
			
		}
	}

	//수정 테스트
	@Test
	public void updateDeptTest() {
		DeptEntity entity = DeptEntity.builder()
				.dno(100)
				.dname("회계과")
				.build();
		DeptEntity dept = deptRepository.save(entity);
		DeptResponseDTO resDTO = new DeptResponseDTO(entity);
		System.out.println("등록된 부서명 : " + resDTO.getDno());
	}
	
	//수정 테스트
	@Test
	@Transactional
	//@Rollback(false) // 🔥 테스트가 끝나도 롤백하지 않고 DB에 반영(커밋)합니다!
	public void deptUpdateTest() {
		deptRepository.deptDnameUpdate("회계부", 10);
		//스프링 부트 테스트 환경에서 @Transactional을 붙였을 때 데이터가 업데이트되지 않는 것처럼 보이는 이유는 
		//스프링이 테스트 완료 후 데이터를 자동으로 롤백(Rollback) 시키기 때문
	}
*/
	//카운트 테스트
	@Test
	public void countByDnameTest() {
		int count1 = deptRepository.countByDname("인사과");
		long count2 = deptRepository.countByDnameContaining("인사");
		
		System.out.println("count1 : " + count1);
		System.out.println("count2 : " + count2);
	}
	
	//검색 테스트
	//지역명 검색(WHERE dname = ?)
	@Test
	public void findByLocTest() {
		List<DeptEntity> dList = deptRepository.findByLoc("목포");
		
		System.out.println("동일값");
		for(DeptEntity entity : dList) {
			DeptResponseDTO dto = new DeptResponseDTO(entity);
			System.out.print(dto.getDno() + "  ");
			System.out.print(dto.getDname() + "  ");
			System.out.println(dto.getLoc());
			
		}
	}

	//지역명 검색(where loc like '%keyword%')
	@Test
	public void findByLocContainingTest() {
		List<DeptEntity> dList = deptRepository.findByLocContaining("목");
		
		System.out.println("포함된값");
		for(DeptEntity entity : dList) {
			DeptResponseDTO dto = new DeptResponseDTO(entity);
			System.out.print(dto.getDno() + "  ");
			System.out.print(dto.getDname() + "  ");
			System.out.println(dto.getLoc());
			
		}
	}

	@Test
	public void findByDnameContainingDescTest() {
		List<DeptEntity> dList = deptRepository.findByDnameContainingOrderByDnoDesc("인사");
		
		System.out.println("부서번호 내림차순");
		for(DeptEntity entity : dList) {
			DeptResponseDTO dto = new DeptResponseDTO(entity);
			System.out.print(dto.getDno() + "  ");
			System.out.print(dto.getDname() + "  ");
			System.out.println(dto.getLoc());
			
		}
	}

}
