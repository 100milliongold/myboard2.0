package com.myboard.spring.core.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

    private static final String KOREA_TIME_ZONE = "Asia/Seoul";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pNum;

    private String pTitle;

    // 생성일자
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = KOREA_TIME_ZONE)
    private Date pCreateDate;

    private Boolean pIsTop;

    private Integer pViewNum;

}