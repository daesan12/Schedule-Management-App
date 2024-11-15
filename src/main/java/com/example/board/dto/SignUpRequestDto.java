package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    @NotBlank(message = "유저명은 필수 입력 항목입니다.")
    @Size(max = 4, message = "유저명은 4글자 이내여야 합니다.")
    private final String username;
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private final String password;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
