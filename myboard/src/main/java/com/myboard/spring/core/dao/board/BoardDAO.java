package com.myboard.spring.core.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.spring.core.aop.ExceptionAspect;
import com.myboard.spring.core.vo.board.BoardConfigVO;
import com.myboard.spring.core.vo.board.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardDAO.class);

	public List<BoardVO> selectList(BoardConfigVO boardconfig) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardconfig", boardconfig); //게시판설정 삽입
		
		return sqlSession.selectList("board.selectList",map);
	}

	public void addBoard(BoardConfigVO boardconfig, BoardVO boardVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardconfig", boardconfig); //게시판설정 삽입
		map.put("board", boardVO); //게시판내용 삽입
		
		sqlSession.insert("board.insertBoard",map);
	}

	public BoardVO getView(BoardConfigVO boardconfig, String bNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardconfig", boardconfig); //게시판설정 삽입
		map.put("bNo", bNo); //게시판번호 삽입
		return sqlSession.selectOne("board.getView", map);
	}

	public void modifyBoard(BoardConfigVO boardconfig, String bNo, BoardVO boardVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardconfig", boardconfig); //게시판설정 삽입
		map.put("bNo", bNo); //게시판설정 삽입
		map.put("board", boardVO);
		
		sqlSession.update("board.modifyBoard", map);
	}

	public void deleteBoard(BoardConfigVO boardconfig, String bNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardconfig", boardconfig); //게시판설정 삽입
		map.put("bNo", bNo); //게시판설정 삽입
		sqlSession.delete("board.deleteBoard", map);
	}
}
