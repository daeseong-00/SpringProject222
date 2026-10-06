package com.mnu.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mnu.sample.entity.BoardEntity;

//JpaRepository 인터페이스를 상속해서 사용자 인터페이스 생성
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
	//count() // 카운트
	//findAll()	//전체목록
	//save(entity)// 등록, 수정(update)
	//findById()//기본키를 이용한 검색
	//delete()//삭제
	
	//사용자 정의 메소드(1. 쿼리 메소드 /  2. @Query 어노테이션)
	//1. 삭제(id, pass)
	@Transactional
	@Modifying
	@Query("delete from BoardEntity board where board.idx= :idx and board.pass= :pass")
	int boardDelete(@Param("idx") int idx, @Param("pass") String pass);
	
	//idx에 해당하는 글의 조회수 증가
	@Transactional
	@Modifying
	@Query("update BoardEntity board set board.readcnt = board.readcnt + 1 where board.idx = :idx")
	void boardHits(@Param("idx") int idx);
	
	//수정처리
	@Transactional
	@Modifying
	@Query("update BoardEntity board set board.subject = :subject, board.contents= :contents  where board.idx = :idx and board.pass= :pass")
	int boardModify(@Param("idx") int idx, @Param("subject") String subject,
						@Param("contents") String contents, @Param("pass") String pass);
	
}
