package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}