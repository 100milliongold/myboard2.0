package com.myboard.spring.core.member;

import java.util.List;
import java.util.Optional;

import com.myboard.spring.core.vo.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByMemberId(String memberId);

    List<Member> findByMemberNickname(String memberNickname);

    List<Member> findByMemberEmail(String memberEmail);

    default Optional<Member> findOneMemberId(String memberId) {
        List<Member> list = findByMemberId(memberId);
        return checkList(list);
    }

    default Optional<Member> findOneNickName(String memberNickname) {
        List<Member> list = findByMemberNickname(memberNickname);
        return checkList(list);
    }

    default Optional<Member> findOneEmail(String email) {
        List<Member> list = findByMemberEmail(email);
        return checkList(list);
    }

    default Optional<Member> checkList(List<Member> list) {
        if (list == null) {
            return Optional.empty();
        } else {
            if (list.size() == 1) {
                return Optional.ofNullable(list.get(0));
            } else {
                return Optional.empty();
            }
        }
    }
}