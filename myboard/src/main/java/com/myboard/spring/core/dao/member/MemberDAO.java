package com.myboard.spring.core.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.spring.core.vo.member.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAO.class);

	public void register(MemberVO member) {
		sqlSession.insert("member.InsertMember",member);
	}

	public void createAuthority(MemberVO member) {
		sqlSession.insert("member.createAuthority",member);
	}

	public MemberVO getMember(String mId) {
		// TODO 자동 생성된 메소드 스텁
		return sqlSession.selectOne("member.getMember",mId);
	}
	
	
}
