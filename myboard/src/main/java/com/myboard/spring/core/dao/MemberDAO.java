package com.myboard.spring.core.dao;

import com.myboard.spring.core.member.MemberRepository;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private MemberRepository memberRepository;

	public Member findByMemberId(String id) {
		return memberRepository.findByMemberId(id).get(0);
	}

	public Member save(Member newUser) {
		return memberRepository.save(newUser);
	}

}
