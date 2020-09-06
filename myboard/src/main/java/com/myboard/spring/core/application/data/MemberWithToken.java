package com.myboard.spring.core.application.data;

import lombok.Getter;

@Getter
public class MemberWithToken {
    private String email;
    private String username;
    private String image;
    private String token;

    public MemberWithToken(MemberData memberData, String token) {
        this.email = memberData.getEmail();
        this.username = memberData.getUsername();
        this.image = memberData.getImage();
        this.token = token;
    }
}
