package com.example.carrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final String[] openEndPoints = {"/", "/sign-in", "/sign-up","/css/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers(openEndPoints).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/sign-in")
                                .successForwardUrl("/")
                                .loginProcessingUrl("/sign-in")
                                .usernameParameter("email")
                                .passwordParameter("password")
                )
                .logout(
                        logoutConfig -> logoutConfig
                                .logoutUrl("/sign-out")
                                .logoutSuccessUrl("/sign-in")
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeCookieName("rememberMe")
                                .tokenValiditySeconds(1 * 60 * 60 * 24)
                                .rememberMeParameter("rememberMe")
                )
                .build();

    }
}
