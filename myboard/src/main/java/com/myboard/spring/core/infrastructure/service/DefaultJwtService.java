package com.myboard.spring.core.infrastructure.service;

import java.util.Date;
import java.util.Optional;

import com.myboard.spring.core.service.JwtService;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class DefaultJwtService implements JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.sessionTime}")
    private int sessionTime;

    @Override
    public String toToken(Member member) {
        return Jwts.builder().setSubject(member.getMemberId()).setExpiration(expireTimeFromNow())
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    @Override
    public Optional<String> getSubFromToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return Optional.ofNullable(claimsJws.getBody().getSubject());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private Date expireTimeFromNow() {
        return new Date(System.currentTimeMillis() + sessionTime * 1000);
    }

}
