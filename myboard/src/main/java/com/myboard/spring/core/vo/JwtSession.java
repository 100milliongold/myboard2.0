package com.myboard.spring.core.vo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;

@Getter
@RedisHash("jwtSession")
public class JwtSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    private String jwttoken;

    @Builder
    public JwtSession(String username, String jwttoken) {
        this.username = username;
        this.jwttoken = jwttoken;
    }

}