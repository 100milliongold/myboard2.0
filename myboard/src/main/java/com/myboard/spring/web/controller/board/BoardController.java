package com.myboard.spring.web.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.spring.core.annotation.SigninRequired;
import com.myboard.spring.core.service.board.BoardConfigService;
import com.myboard.spring.core.service.board.BoardService;
import com.myboard.spring.core.vo.board.BoardConfigVO;
import com.myboard.spring.core.vo.board.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardConfigService boardConfigService;
	
	// 리스트
	@RequestMapping(value="/{board_table}",method={RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> list(@PathVariable("board_table") String board_table) {
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", boardService.getList(boardconfig));
		result.put("status", true);
		
		return result;
	}
	
	
	//글작성
	@SigninRequired("USER")
	@RequestMapping(value="/{board_table}",produces = {"application/json;charset=UTF-8"},method={RequestMethod.PUT})
	@ResponseBody
	public Map<String, Object> write(@RequestBody BoardVO boardVO,@PathVariable("board_table") String board_table){
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.addBoard(boardconfig,boardVO);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);
				
		return result;
	}
	
	//글보기
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> view(@PathVariable("board_table") String board_table,@PathVariable("bNo") String bNo) {
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", boardService.getView(boardconfig,bNo));
		result.put("status", true);
		
		return result;
	}
	
	//글수정
	@SigninRequired("USER")
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.PATCH})
	@ResponseBody
	public Map<String, Object> modify(
			@RequestBody BoardVO boardVO
			,@PathVariable("board_table") String board_table
			,@PathVariable("bNo") String bNo
			,HttpSession session
			) throws Exception{
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.modifyBoard(boardconfig,bNo,boardVO);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);
				
		return result;
	}
	
	//글삭제
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.DELETE})
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("board_table") String board_table,@PathVariable("bNo") String bNo){
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.deleteBoard(boardconfig,bNo);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);
				
		return result;
	}
}
