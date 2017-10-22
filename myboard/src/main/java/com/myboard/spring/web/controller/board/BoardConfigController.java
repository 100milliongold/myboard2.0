package com.myboard.spring.web.controller.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.spring.core.service.board.BoardConfigService;

@Controller
@RequestMapping("/boardConfig")
public class BoardConfigController {
	
	@Autowired
	private BoardConfigService boardConfigService;
	// 게시판 리스트
	@RequestMapping(value="/list",method={RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> list() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", boardConfigService.getBoardList());
		result.put("status", true);
		return result;
	}
	
}
