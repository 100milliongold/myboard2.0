package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.JwtSession;

import org.springframework.data.repository.CrudRepository;

public interface JwtSessionRepository extends CrudRepository<JwtSession, String> {

}