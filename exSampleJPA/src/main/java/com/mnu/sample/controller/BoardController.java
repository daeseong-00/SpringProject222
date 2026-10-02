package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mnu.sample.dto.BoardRequestDTO;
import com.mnu.sample.dto.BoardResponseDTO;
import com.mnu.sample.repository.BoardRepository;
import com.mnu.sample.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("Board")
public class BoardController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(BoardController.class);
	
	private final BoardService boardService;
	
	@GetMapping("board_list")
	public String boardList(Model model) {
		log.info("Board Call : board_list");
		model.addAttribute("bList", boardService.boardList());
		model.addAttribute("totcount", boardService.boardCount());
		
		return "/Board/board_list";
	}

	//등록 폼
	@GetMapping("board_write")
	public String boardWrite() {
		log.info("Board Call : board_write");
		return "/Board/board_write";
		
	}
	//등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardRequestDTO board) {
		log.info("Board Call : board_write_pro");
		int row = boardService.boardWrite(board);
		if(row==0) {
			return "Board/board_write";
		}else {
			return "redirect:board_list";
		}
		
	}
	
	//리스트에서 제목 선택시 idx을 이용한 상세보기(view)
	@GetMapping("board_view")
	public String boardView(@RequestParam("idx") int idx, Model model) {
		log.info("Board Call : board_view");
		BoardResponseDTO board = boardService.boardView(idx);
		model.addAttribute("board", board);
		model.addAttribute("newLineChar", "\n");//ㄱ게시글 내용의 <br> 처리용
		
		return "Board/board_view";
	}
	
	//삭제 폼
	@GetMapping("board_delete")
	public String boardDelete() {
		log.info("Board Call : board_delete");
		
		return "Board/board_delete";
	}
	
	//삭제처리
	@PostMapping("board_delete")
	public String boardDeletePro(@RequestParam("idx") int idx, @RequestParam("pass") String pass, Model model) {
		log.info("Board Call : board_delete_pro");
		int row = boardService.boardDelete(idx, pass);
		model.addAttribute("row", row);
		return "Board/board_delete_pro";// 경고 출력용
	}
}
