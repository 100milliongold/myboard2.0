package com.myboard.spring.core.application.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberData {
    private String id;
    private String email;
    private String username;
    private String image;
}
