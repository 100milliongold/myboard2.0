package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.board.BoardVO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositiry extends JpaRepository<BoardVO, Long> {

}