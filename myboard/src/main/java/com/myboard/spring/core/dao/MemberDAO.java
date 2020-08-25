package com.myboard.spring.core.dao;

import java.util.List;

import com.myboard.spring.core.vo.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAO.class);

	public void register(Member member) {
		return;
	}

	public void createAuthority(Member member) {
	}

	public Member getMember(String mId) {
		return null;
	}

	public List<String> getAuthorities(Member member) {
		return null;
	}

}
