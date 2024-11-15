package com.example.board.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

   // 로그인 rawPassword , 암호화된 DB rawPassword
    public boolean matches(String rawPassword, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;
    }

}