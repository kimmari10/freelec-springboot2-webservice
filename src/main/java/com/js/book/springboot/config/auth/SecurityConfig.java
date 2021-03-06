package com.js.book.springboot.config.auth;

import com.js.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and().authorizeRequests()
                .antMatchers("/login", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/map", "/navi", "/api/bot/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.GUEST.name())
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/")
                .and().oauth2Login().loginPage("/login")
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }

}
