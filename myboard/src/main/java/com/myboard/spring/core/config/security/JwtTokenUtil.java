package com.myboard.spring.core.config.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new ConcurrentHashMap<>();
		return doGenerateToken(claims, userDetails.getUsername(), userDetails.getAuthorities());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String user_name,
			Collection<? extends GrantedAuthority> collection) {

		claims.put("scopes", collection);

		return Jwts.builder().setClaims(claims).setSubject(user_name).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getUsernameFromToken(String jwtToken) {
		return getClaimFromToken(jwtToken, Claims::getSubject);
	}

	private <T> T getClaimFromToken(String jwtToken, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(jwtToken);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String jwtToken) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody();
	}

	// validate token
	public boolean validateToken(String jwtToken, UserDetails userDetails) {
		final String username = getUsernameFromToken(jwtToken);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
	}

	// check if the token has expired
	private boolean isTokenExpired(String jwtToken) {
		final Date expiration = getExpirationDateFromToken(jwtToken);
		return expiration.before(new Date());
	}

	// retrieve expiration date from jwt token
	private Date getExpirationDateFromToken(String jwtToken) {
		return getClaimFromToken(jwtToken, Claims::getExpiration);
	}
}