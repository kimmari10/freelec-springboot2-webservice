package com.js.book.springboot.service;

import com.js.book.springboot.config.auth.LoginUser;
import com.js.book.springboot.config.auth.dto.SessionUser;
import com.js.book.springboot.domain.user.User;
import com.js.book.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public long join(@LoginUser SessionUser sessionUser) {

        User user = userRepository.findByEmail(sessionUser.getEmail()).orElseThrow(() ->
                new IllegalArgumentException("이미 회원인 사용자입니다. email = "+ sessionUser.getEmail()));

        user.join();

        return user.getId();
    }
}
