package com.myboard.spring.core.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Authority - 사용자 권한 설정
 */
@Entity
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aNum;

    // 권한 코드
    private String aName;

    // 권한 설명
    private String aContent;
}