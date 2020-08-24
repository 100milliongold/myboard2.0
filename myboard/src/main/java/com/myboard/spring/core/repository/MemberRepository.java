package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.member.MemberVO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, Long> {

}