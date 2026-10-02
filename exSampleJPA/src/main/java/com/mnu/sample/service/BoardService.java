package com.mnu.sample.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnu.sample.dto.BoardRequestDTO;
import com.mnu.sample.dto.BoardResponseDTO;
import com.mnu.sample.entity.BoardEntity;
import com.mnu.sample.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //Bean 주입
public class BoardService {
	private final BoardRepository boardRepository;
	
	// 등록 처리
	@Transactional
	public int boardWrite(BoardRequestDTO board) {
		return boardRepository.save(board.toEntity()).getIdx();
		//등록후 등록된 idx 반환
	}
	
	// 카운트(전체 게시글 수)
	@Transactional
	public long boardCount() {
		return boardRepository.count();
	}
	
	// 전체 목록
	@Transactional
	public List<BoardResponseDTO> boardList(){
		return boardRepository.findAll()
				.stream()
				// Board 엔티티의 getIdx()를 기준으로 내림차순(reversed) 정렬
	            .sorted(Comparator.comparing(BoardEntity::getIdx).reversed()) 
				.map(BoardResponseDTO::new)
				//.collect(Collectors.toList());
				.toList();//JDK 16이상
		// BoardRepository결과로 넘어온 BoardEntity의 Stream을 map을 통해 BoardReponseDto로 변환 
        //   -> List로 반환하는 메서드
	}
	
	//상세보기(View)
	@Transactional
	public BoardResponseDTO boardView(int idx) {
		BoardEntity boardEntity = boardRepository.findById(idx)
				.orElseThrow(()->new IllegalArgumentException("idx 없음"));
		
		BoardResponseDTO board = new BoardResponseDTO(boardEntity);
		return board;
	}
	
	//삭제
	@Transactional
	public int boardDelete(int idx, String pass) {
		return boardRepository.boardDelete(idx, pass);
	}
}
