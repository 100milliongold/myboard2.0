package com.myboard.spring.core.service;

import java.util.Arrays;

import com.myboard.spring.core.dao.MemberDAO;
import com.myboard.spring.core.repository.JwtSessionRepository;
import com.myboard.spring.core.vo.JwtSession;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private JwtSessionRepository jwtSessionRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member user = memberDAO.findByMemberId(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getMemberId(), user.getMemberPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

	public Member save(Member user) {
		Member newUser = new Member();
		newUser.setMemberId(user.getMemberId());
		newUser.setMemberEmail(user.getMemberEmail());
		newUser.setMemberNickname(user.getMemberNickname());
		newUser.setMemberPassword(bcryptEncoder.encode(user.getMemberPassword()));
		return memberDAO.save(newUser);
	}

	public void saveToken(String username, String token) {
		Member user = memberDAO.findByMemberId(username);
		// token 저장
		// String memberId = user.getMemberId();
		JwtSession jwtSession = JwtSession.builder().username(username).jwttoken(token).build();
		jwtSessionRepository.save(jwtSession);
	}

}