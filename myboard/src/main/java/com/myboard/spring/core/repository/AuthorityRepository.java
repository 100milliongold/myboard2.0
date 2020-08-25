package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}