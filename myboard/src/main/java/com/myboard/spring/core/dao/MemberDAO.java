package com.myboard.spring.core.dao;

import com.myboard.spring.core.repository.MemberRepository;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private MemberRepository memberRepository;

	public Member findByUsername(String id) {
		return memberRepository.findByMemberId(id).get(0);
	}

}
