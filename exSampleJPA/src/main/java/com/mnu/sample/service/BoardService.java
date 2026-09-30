package com.mnu.sample.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnu.sample.dto.BoardRequestDTO;
import com.mnu.sample.dto.BoardResponseDTO;
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
	
	// 전체 목록
	@Transactional
	public List<BoardResponseDTO> boardList(){
		return boardRepository.findAll()
				.stream()
				.map(BoardResponseDTO::new)
				.collect(Collectors.toList());
		// BoardRepository결과로 넘어온 BoardEntity의 Stream을 map을 통해 BoardReponseDto로 변환 
        //   -> List로 반환하는 메서드
	}
}
