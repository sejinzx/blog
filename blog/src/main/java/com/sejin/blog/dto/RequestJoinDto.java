package com.sejin.blog.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoinDto {

    @NotNull
    @Size(min = 6, max = 20, message = "아이디는 6자 이상 20자 이하여야 합니다.")
    private String userId;

    @NotNull
    @Size(min = 8, max = 30, message = "비밀번호는 8자 이상 30자 이하여야 합니다.")
    private String userPw;

    @NotNull
    private String userEmail;

    @NotNull
    private String userNickname;

}
