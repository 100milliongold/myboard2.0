package com.myboard.spring.core.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.myboard.spring.core.api.exception.InvalidRequestException;
import com.myboard.spring.core.application.MemberQueryService;
import com.myboard.spring.core.application.data.MemberData;
import com.myboard.spring.core.application.data.MemberWithToken;
import com.myboard.spring.core.member.MemberRepository;
import com.myboard.spring.core.service.JwtService;
import com.myboard.spring.core.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
public class MemberApi {

    @Value("${image.default}")
    private String defaultImage;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberQueryService memberQueryService;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(path = "/users", method = POST)
    public ResponseEntity createUser(@Valid @RequestBody RegisterParam registerParam, BindingResult bindingResult) {
        checkInput(registerParam, bindingResult);

        Member member = new Member(null, registerParam.getId(), registerParam.getPassword(), registerParam.getEmail(),
                registerParam.getUsername(), new Date(), defaultImage, true);

        memberRepository.save(member);
        MemberData memberData = memberQueryService.findByMemberNum(member.getMemberNum()).get();
        return ResponseEntity.status(201)
                .body(memberResponse(new MemberWithToken(memberData, jwtService.toToken(member))));
    }

    private void checkInput(@Valid @RequestBody RegisterParam registerParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }

        if (memberRepository.findOneNickName(registerParam.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "DUPLICATED", "duplicated username");
        }

        if (memberRepository.findOneEmail(registerParam.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "DUPLICATED", "duplicated email");
        }

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }
    }

    private Map<String, Object> memberResponse(MemberWithToken memberWithToken) {
        return new ConcurrentHashMap<String, Object>() {
            {
                put("member", memberWithToken);
            }
        };
    }

}

@Getter
@JsonRootName("user")
@NoArgsConstructor
class LoginParam {
    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    private String id;
    @NotBlank(message = "can't be empty")
    private String password;
}

@Getter
@JsonRootName("user")
@NoArgsConstructor
class RegisterParam {
    @NotBlank(message = "can't be empty")
    private String id;
    @NotBlank(message = "can't be empty")
    private String username;

    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    private String email;

    @NotBlank(message = "can't be empty")
    private String password;
}