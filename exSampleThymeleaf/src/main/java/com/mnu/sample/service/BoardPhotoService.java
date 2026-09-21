package com.mnu.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnu.sample.domain.BoardDTO;
import com.mnu.sample.domain.BoardPhotoDTO;
import com.mnu.sample.domain.PageSearchDTO;
import com.mnu.sample.mapper.BoardPhotoMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class BoardPhotoService {
	@Autowired
	private BoardPhotoMapper boardPhotoMapper;
	
	// 최근 글 n개 검색
	public List<BoardPhotoDTO> boardTopList(int num){
		return boardPhotoMapper.boardTopList(num);
	}

	//1. 전체 글수 카운트
	public int boardCount(PageSearchDTO pageSearchDTO) {
		return boardPhotoMapper.boardCount(pageSearchDTO);
	}
	
	//2. 전체목록 리스트(검색, 페이지)
	public List<BoardPhotoDTO> boardList(PageSearchDTO pageSearchDTO){
		return boardPhotoMapper.boardList(pageSearchDTO);
	}

	//3. 글 등록 
	public int boardWrite(BoardPhotoDTO boardPhotoDTO) {
		return boardPhotoMapper.boardWrite(boardPhotoDTO);
	}
	
	//4-5. 특정글 검색(view, 수정), 조회수 증가
	public BoardPhotoDTO boardView(int idx,  HttpServletRequest request, HttpServletResponse response) {
		//쿠키설정
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				info = cookies[i];
				if(info.getName().equals("boardPhotoCookie"+idx)) {
					bool = true;
					break;
				}
			}
		}
		String str = ""+System.currentTimeMillis();
		if(!bool) {
			//쿠키생성
			info = new Cookie("boardPhotoCookie"+idx, str);
			//info.setMaxAge(24*60*60);//1일
			info.setMaxAge(60*5);//5분
			response.addCookie(info);
			boardPhotoMapper.boardHits(idx);	
		}
			
		return boardPhotoMapper.boardSelect(idx);
		
	}
	//6. 수정처리(폼)
	public BoardPhotoDTO boardModify(int idx) {
		return boardPhotoMapper.boardSelect(idx);
	}

	//7. 수정처리(처리)
	public int boardModifyPro(BoardPhotoDTO boardPhotoDTO) {
		
		return boardPhotoMapper.boardModify(boardPhotoDTO);
	}

	//8. 삭제처리
	public int boardDelete(BoardPhotoDTO boardPhotoDTO) {
		
		return boardPhotoMapper.boardDelete(boardPhotoDTO);
	}

}
