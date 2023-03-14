package com.boram.life.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    /* 비밀번호 암호화에 사용할 객체 : BCryptPasswordEncoder bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain loginFilter(HttpSecurity http) throws Exception{
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/loginForm")
                    .defaultSuccessUrl("/index")
                .permitAll()
                    .and()
                .logout()
                .and()
                .build();

    }
}
