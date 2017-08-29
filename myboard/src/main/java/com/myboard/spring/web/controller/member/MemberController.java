package com.myboard.spring.web.controller.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.spring.core.service.member.MemberService;
import com.myboard.spring.core.vo.member.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원가입
	@RequestMapping(value="/register",produces = {"application/json;charset=UTF-8"},method={RequestMethod.PUT})
	@ResponseBody
	public Map<String, String> register(@RequestBody MemberVO member){
		
		memberService.register(member);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
				
		return result;
	}
	
	//로그인
	@RequestMapping(value="/login",produces = {"application/json;charset=UTF-8"},method={RequestMethod.POST})
	@ResponseBody
	public Map<String, String> login(@RequestBody MemberVO login){
		
		MemberVO memberVO = memberService.getMember(login);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
				
		return result;
	}
}
