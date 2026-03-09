package com.sejin.blog.controller;

import com.sejin.blog.dto.RequestJoinDto;
import com.sejin.blog.dto.RequestLoginDto;
import com.sejin.blog.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/user-service")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLoginDto requestLoginDto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer ");

            return ResponseEntity.ok().headers(headers).body("로그인 성공");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("로그인 실패: 인증 실패");
        }

    }

    @PostMapping("/users")
    @Operation(summary = "회원가입", description = "회원가입")
    public String createUser(@RequestBody RequestJoinDto requestJoinDto) {

        boolean success = userService.createUser(requestJoinDto);
        if (success) {
            return "회원가입 성공";
        } else {
            return "회원가입 실패";
        }

    }

}
