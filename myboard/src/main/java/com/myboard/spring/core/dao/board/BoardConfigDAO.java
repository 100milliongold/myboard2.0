package com.myboard.spring.core.dao.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.spring.core.vo.board.BoardConfigVO;

@Repository
public class BoardConfigDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public BoardConfigVO viewBoardConfig(String board_table){
		
		if(board_table == null)return null;
		return sqlSession.selectOne("boardconfig.viewBoardConfig", board_table);
		
	}

}
