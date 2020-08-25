package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}