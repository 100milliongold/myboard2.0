package com.myboard.spring.core.service.member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myboard.spring.core.dao.member.MemberDAO;
import com.myboard.spring.core.vo.member.MemberVO;

@Service
public class MemberService {
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	
	@Autowired
	private MemberDAO memberDAO;

	public void register(MemberVO member) {
		if(member.getmId() == null || member.getmPassword() == null || member.getmName() == null){
			return;
		}
		String rawPassword = member.getmPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		member.setmPassword(encodedPassword);
		
		List<String> mList = new ArrayList<String>();
		mList.add("USER");
		member.setAuthorities(mList);

		memberDAO.register(member);
		memberDAO.createAuthority(member);
	}

	public MemberVO getMember(MemberVO login) {
		return memberDAO.getMember(login.getmId());
	}

	
}
