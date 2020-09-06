package com.myboard.spring.core.core.member;

public interface EncryptService {
    String encrypt(String password);

    boolean check(String checkPassword, String realPassword);
}
