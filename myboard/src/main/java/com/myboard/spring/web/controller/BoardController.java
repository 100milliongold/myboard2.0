package com.myboard.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.myboard.spring.core.service.MemberService;
import com.myboard.spring.core.vo.Board;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private MemberService memberService;

	// 글작성
	@RequestMapping(value = "/board", produces = { "application/json;charset=UTF-8" }, method = { RequestMethod.PUT })
	@ResponseBody
	public Map<String, Object> write(@RequestBody Board board, @PathVariable("board_table") String board_table,
			HttpSession session) throws Exception {

		Member member = memberService.getMember((String) session.getAttribute("mId"));

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}

	// 글보기
	@RequestMapping(value = "/board/{bNo}", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> view(@PathVariable("bNo") String bNo) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}

	// 글수정
	@RequestMapping(value = "/board/{bNo}", method = { RequestMethod.PATCH })
	@ResponseBody
	public Map<String, Object> modify(@RequestBody Board board, @PathVariable("board_table") String board_table,
			@PathVariable("bNo") String bNo, HttpSession session) throws Exception {

		Member member = memberService.getMember((String) session.getAttribute("mId"));

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}

	// 글삭제
	@RequestMapping(value = "/{board_table}/{bNo}", method = { RequestMethod.DELETE })
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("board_table") String board_table,
			@PathVariable("bNo") String bNo) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}
}
