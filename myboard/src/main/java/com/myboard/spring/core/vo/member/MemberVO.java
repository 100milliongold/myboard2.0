package com.myboard.spring.core.vo.member;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.myboard.spring.core.vo.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mNum;

	@Column(unique = true)
	private String mId;
	private String mName;
	private String mPassword;

	@OneToMany
	@JoinColumn(name = "mNum")
	private Set<BoardVO> boardList;

}
