package com.mnu.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mnu.sample.entity.DeptEntity;

public interface DeptRepository extends JpaRepository<DeptEntity, Integer> {
	//T : Entity  , ID : 기본키(객체)
	
	//사용자 정의 메소드 생성(추상메소드)
	//public int deptCount();
	// JPaRepository 인터페이스를 상속만으로도  별도의 메서드를 정의하지 않아도 
	//기본적인 CRUD(생성, 조회, 수정, 삭제), 페이징, 정렬 및 배치 처리를 위한 다양한 메서드를 즉시 사용
	//지역명을 이용한 검색
	List<DeptEntity> findByLoc(String loc);
	//이름을 이용한 검색
	List<DeptEntity> findByDname(String name);
/*	
   //사용자 정의 메소드 구현
   @Modifying
   @Query("update EmpEntity emp set emp.commission = emp.commission + 100 where emp.eno = :eno")
   void empCommissionPlus(int eno); //특정 사원의 커미션을 + 100 올려주시오
   //void empCommissionPlus(@Param("eno") int eno); // 가능
*/	
   @Modifying
   @Query("update DeptEntity dept set dept.dname = :dname where dept.dno = :dno")
   void deptDnameUpdate(@Param("dname") String dname, @Param("dno") int dno); 


}
