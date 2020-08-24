package com.myboard.spring.core.service.member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myboard.spring.core.dao.member.MemberDAO;
import com.myboard.spring.core.vo.member.MemberVO;

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
	public void register(MemberVO member) {
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
	public MemberVO getMember(String mId) {
		// 회원기본정보
		MemberVO member = memberDAO.getMember(mId);

		return member;
	}

	/**
	 * 아이디 패스워드 비교
	 * 
	 * @param login
	 * @return
	 */
	public boolean isAuthoritie(MemberVO login) {
		if (login == null || login.getMId() == null || login.getMPassword() == null) {
			return false;
		}

		MemberVO member = getMember(login.getMId());
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
