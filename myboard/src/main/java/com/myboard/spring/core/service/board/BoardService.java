package com.myboard.spring.core.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.spring.core.dao.board.BoardDAO;
import com.myboard.spring.core.service.member.MemberService;
import com.myboard.spring.core.vo.board.BoardConfigVO;
import com.myboard.spring.core.vo.board.BoardVO;
import com.myboard.spring.core.vo.member.MemberVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private MemberService memberService;
	
	public List<BoardVO> getList(BoardConfigVO boardconfig) {
//		if(true){
//			throw new RuntimeException("서버에러발생");
//		}
		return boardDAO.selectList(boardconfig);
	}

	public void addBoard(BoardConfigVO boardconfig, BoardVO boardVO, MemberVO member) {
		boardDAO.addBoard(boardconfig,boardVO,member);
	}

	public BoardVO getView(BoardConfigVO boardconfig, String bNo) {
		return boardDAO.getView(boardconfig,bNo);
	}

	public void modifyBoard(BoardConfigVO boardconfig, String bNo, BoardVO boardVO, MemberVO member) {
		
		// 작성한 사용자 정보 읽어오기
		MemberVO writer = memberService.getMember(getView(boardconfig,bNo).getmId());
		if(writer.getmId().equals(member.getmId()) || member.getAuthorities().contains("ADMIN")){
			boardDAO.modifyBoard(boardconfig,bNo,boardVO);
		}else{
			throw new SecurityException("권한이 없습니다.");
		}
		
	}

	public void deleteBoard(BoardConfigVO boardconfig, String bNo) {
		boardDAO.deleteBoard(boardconfig, bNo);
	}
	
}
