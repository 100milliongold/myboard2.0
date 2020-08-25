package com.myboard.spring.core.service;

import java.util.ArrayList;
import java.util.List;

import com.myboard.spring.core.dao.MemberDAO;
import com.myboard.spring.core.vo.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private MemberDAO memberDAO;

	/**
	 * 회원가입
	 * 
	 * @param member
	 */
	public void register(Member member) {
		if (member.getMId() == null || member.getMPassword() == null || member.getMId() == null) {
			return;
		}
		String rawPassword = member.getMPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		member.setMPassword(encodedPassword);

		List<String> mList = new ArrayList<String>();
		mList.add("USER");

		memberDAO.register(member);
		memberDAO.createAuthority(member);
	}

	/**
	 * 회원정보 읽어오기
	 * 
	 * @param id
	 * @return
	 */
	public Member getMember(String mId) {
		// 회원기본정보
		Member member = memberDAO.getMember(mId);

		return member;
	}

	/**
	 * 아이디 패스워드 비교
	 * 
	 * @param login
	 * @return
	 */
	public boolean isAuthoritie(Member login) {
		if (login == null || login.getMId() == null || login.getMPassword() == null) {
			return false;
		}

		Member member = getMember(login.getMId());
		boolean isAuthoritie = false;

		if (member != null && member.getMId().equals(login.getMId())
				&& new BCryptPasswordEncoder().matches(login.getMPassword(), member.getMPassword())) {
			isAuthoritie = true;
		} else {
			isAuthoritie = false;
		}

		return isAuthoritie;
	}

}
