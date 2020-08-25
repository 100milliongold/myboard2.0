package com.myboard.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.myboard.spring.core.service.MemberService;
import com.myboard.spring.core.vo.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	// 회원가입
	@RequestMapping(value = "/register", produces = { "application/json;charset=UTF-8" }, method = {
			RequestMethod.PUT })
	@ResponseBody
	public Map<String, Object> register(@RequestBody final Member member) {

		memberService.register(member);

		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}

	// 로그인
	@RequestMapping(value = "/login", produces = { "application/json;charset=UTF-8" }, method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> login(@RequestBody final Member login, final HttpSession session) {

		final boolean isAuthoritie = memberService.isAuthoritie(login);
		if (isAuthoritie) {
			final Member member = memberService.getMember(login.getMId());
			session.setAttribute("isLogin", true);
			session.setAttribute("mId", member.getMId());

			// List<String> authlist = member.getAuthorities();
			// for ( String auth : authlist) {
			// LOGGER.debug("authlist :"+auth);
			// }
		} else {
			throw new SecurityException("로그인 실패");
		}

		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);

		return result;
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> logout(final HttpSession session) {
		final Map<String, Object> result = new HashMap<String, Object>();
		session.invalidate();
		result.put("status", true);
		return result;
	}
}
