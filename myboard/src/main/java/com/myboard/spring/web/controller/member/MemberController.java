package com.myboard.spring.web.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
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
	public Map<String, Object> login(@RequestBody MemberVO login,HttpSession session){
		
		boolean isAuthoritie = memberService.isAuthoritie(login);
		if(isAuthoritie){
			MemberVO memberVO = memberService.getMember(login);
			session.setAttribute("isLogin", true);
			session.setAttribute("mId", memberVO.getmId());
			session.setAttribute("role", memberVO.getAuthorities().toArray(new String[memberVO.getAuthorities().size()]));
			
//			List<String> authlist = memberVO.getAuthorities();
//			for ( String auth : authlist) {
//				LOGGER.debug("authlist :"+auth);
//			}
		}else{
			throw new SecurityException("로그인 실패");
		}
		
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);
				
		return result;
	}
}
