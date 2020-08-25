package com.myboard.spring.core.repository;

import com.myboard.spring.core.vo.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}