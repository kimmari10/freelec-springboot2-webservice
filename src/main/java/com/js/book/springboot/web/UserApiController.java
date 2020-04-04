package com.js.book.springboot.web;

import com.js.book.springboot.config.auth.LoginUser;
import com.js.book.springboot.config.auth.dto.SessionUser;
import com.js.book.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user/join")
    public Long save(@LoginUser SessionUser sessionUser) {
        return userService.join(sessionUser);
    }

}
