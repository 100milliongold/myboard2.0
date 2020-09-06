package com.myboard.spring.core.application;

import java.util.Optional;

import com.myboard.spring.core.application.data.MemberData;
import com.myboard.spring.core.member.MemberRepository;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService {

    @Autowired
    private MemberRepository memberRepository;

    public Optional<MemberData> findByMemberNum(Long memberNum) {
        Optional<Member> find_member = memberRepository.findById(memberNum);
        if (find_member.isPresent()) {
            Member member = find_member.get();
            MemberData res = new MemberData(member.getMemberId(), member.getMemberEmail(), member.getMemberNickname(),
                    member.getThumbnail());
            return Optional.ofNullable(res);
        } else {
            return Optional.empty();
        }
    }
}
