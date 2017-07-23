package com.myboard.spring.core.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.spring.core.dao.board.BoardDAO;
import com.myboard.spring.core.vo.board.BoardConfigVO;
import com.myboard.spring.core.vo.board.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> getList(BoardConfigVO boardconfig) {
//		if(true){
//			throw new RuntimeException("서버에러발생");
//		}
		return boardDAO.selectList(boardconfig);
	}

	public void addBoard(BoardConfigVO boardconfig, BoardVO boardVO) {
		boardDAO.addBoard(boardconfig,boardVO);
	}

	public BoardVO getView(BoardConfigVO boardconfig, String bNo) {
		return boardDAO.getView(boardconfig,bNo);
	}

	public void modifyBoard(BoardConfigVO boardconfig, String bNo, BoardVO boardVO) {
		boardDAO.modifyBoard(boardconfig,bNo,boardVO);
	}

	public void deleteBoard(BoardConfigVO boardconfig, String bNo) {
		boardDAO.deleteBoard(boardconfig, bNo);
	}
	
}
