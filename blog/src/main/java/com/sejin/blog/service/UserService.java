package com.sejin.blog.service;

import com.sejin.blog.domain.UserDomain;
import com.sejin.blog.dto.RequestJoinDto;
import com.sejin.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder pwdEncoder;

    public boolean createUser(RequestJoinDto requestJoinDto){
        try{
            UserDomain userDomain = UserDomain.builder()
                    .userId(requestJoinDto.getUserId())
                    .userPw(pwdEncoder.encode(requestJoinDto.getUserPw()))
                    .userEmail(requestJoinDto.getUserEmail())
                    .userNickname(requestJoinDto.getUserNickname())
                    .build();

            userRepository.save(userDomain);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }

    }

}
