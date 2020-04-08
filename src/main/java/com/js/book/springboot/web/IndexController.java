package com.js.book.springboot.web;

import com.js.book.springboot.config.auth.CustomOAuth2UserService;
import com.js.book.springboot.config.auth.LoginUser;
import com.js.book.springboot.config.auth.dto.SessionUser;
import com.js.book.springboot.domain.user.Role;
import com.js.book.springboot.service.PostsService;
import com.js.book.springboot.service.UserService;
import com.js.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final UserService userService;
    private final HttpSession httpSession;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAll());

        if(user != null) {
            model.addAttribute("user", user);
            model.addAttribute("isRoleGuest", user.getRole() == Role.GUEST);
        }

        return "index";
    }

    @GetMapping("/login")
    public String login(@LoginUser SessionUser user) {
        if(user != null) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
