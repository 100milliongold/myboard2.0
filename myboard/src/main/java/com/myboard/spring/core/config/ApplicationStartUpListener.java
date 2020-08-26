package com.myboard.spring.core.config;

import com.myboard.spring.core.repository.MemberRepository;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

/**
 * ApplicationStartUpListener
 */
@Slf4j // lombok
@Profile("local") // profile이 local일때만 활성화
@Configuration
public class ApplicationStartUpListener {

    @Autowired
    private MemberRepository memberRepository;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernate_status;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();

        if (memberRepository.findAll().size() == 0) {

            String id = "admin";
            String password = "admin";

            log.warn("유저정보가 없습니다. Create Test Id : {} pw : {}", id, password);
            memberRepository.deleteAll();
            Member member = new Member();
            member.setMemberId(id);
            member.setMemberEmail("admin@test.com");
            member.setMemberIsUsed(true);
            member.setMemberNickname("관리자");
            member.setMemberPassword(bCryp.encode(password));

            memberRepository.save(member);
        }

    }
}
