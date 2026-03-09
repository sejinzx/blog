package com.sejin.blog.service;

import com.sejin.blog.domain.UsersDetails;
import com.sejin.blog.domain.UserDomain;
import com.sejin.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 session(내부 Authentication(내부 UserDetails))
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB에서 사용자 조회 (userId 필드 기준)
        UserDomain userEntity = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username));

        return new UsersDetails(userEntity);
    }
}