package com.myboard.spring.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Board {
	private static final String KOREA_TIME_ZONE = "Asia/Seoul";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boardNum;

	private String boardTitle;

	// 생성일자
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = KOREA_TIME_ZONE)
	private Date boardCreateDate;

	// 사용여부
	private Boolean boardIsUsed;

	@OneToMany(mappedBy = "board")
	private List<Post> postList;

}
