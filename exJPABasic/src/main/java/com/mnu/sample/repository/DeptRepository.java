package com.mnu.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnu.sample.entity.DeptEntity;

public interface DeptRepository extends JpaRepository<DeptEntity, Integer> {
	//T : Entity  , ID : 기본키(객체)
	
	//사용자 정의 메소드 생성(추상메소드)
	//public int deptCount();
	// JPaRepository 인터페이스를 상속만으로도  별도의 메서드를 정의하지 않아도 
	//기본적인 CRUD(생성, 조회, 수정, 삭제), 페이징, 정렬 및 배치 처리를 위한 다양한 메서드를 즉시 사용
	
}
