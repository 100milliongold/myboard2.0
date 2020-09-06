package com.myboard.spring.core.service;

import java.util.Optional;

import com.myboard.spring.core.vo.Member;

import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String toToken(Member user);

    Optional<String> getSubFromToken(String token);
}
