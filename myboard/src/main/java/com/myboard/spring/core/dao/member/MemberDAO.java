package com.myboard.spring.core.dao.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myboard.spring.core.vo.member.MemberVO;

@Repository
public class MemberDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAO.class);

	public void register(MemberVO member) {
		return;
	}

	public void createAuthority(MemberVO member) {
	}

	public MemberVO getMember(String mId) {
		return null;
	}

	public List<String> getAuthorities(MemberVO member) {
		return null;
	}

}
