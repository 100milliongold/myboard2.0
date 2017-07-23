package com.myboard.spring.web.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public List<BoardVO> list(@PathVariable("board_table") String board_table) {
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		return boardService.getList(boardconfig);
	}
	
	
	//글작성
	@RequestMapping(value="/{board_table}",produces = {"application/json;charset=UTF-8"},method={RequestMethod.PUT})
	@ResponseBody
	public Map<String, String> write(@RequestBody BoardVO boardVO,@PathVariable("board_table") String board_table){
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.addBoard(boardconfig,boardVO);
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
				
		return result;
	}
	
	//글보기
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.GET})
	@ResponseBody
	public BoardVO view(@PathVariable("board_table") String board_table,@PathVariable("bNo") String bNo) {
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		return boardService.getView(boardconfig,bNo);
	}
	
	//글수정
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.PATCH})
	@ResponseBody
	public Map<String, String> modify(@RequestBody BoardVO boardVO,@PathVariable("board_table") String board_table,@PathVariable("bNo") String bNo){
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.modifyBoard(boardconfig,bNo,boardVO);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
				
		return result;
	}
	
	//글삭제
	@RequestMapping(value="/{board_table}/{bNo}",method={RequestMethod.DELETE})
	@ResponseBody
	public Map<String, String> delete(@PathVariable("board_table") String board_table,@PathVariable("bNo") String bNo){
		
		BoardConfigVO boardconfig = boardConfigService.viewBoardConfig(board_table);
		if(boardconfig == null) return null;
		
		boardService.deleteBoard(boardconfig,bNo);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
				
		return result;
	}
}
