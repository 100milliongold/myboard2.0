package com.myboard.spring.core.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.spring.core.dao.board.BoardConfigDAO;
import com.myboard.spring.core.vo.board.BoardConfigVO;

@Service
public class BoardConfigService {
	
	@Autowired
	BoardConfigDAO boardConfigDAO;
	
	public BoardConfigVO viewBoardConfig(String board_table){
		return boardConfigDAO.viewBoardConfig(board_table);
	}

	public List<BoardConfigVO> getBoardList() {
		return boardConfigDAO.getBoardList();
	}
}
