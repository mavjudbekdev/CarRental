package com.example.carrental.controller;

import com.example.carrental.config.PasswordEncoderConfig;
import com.example.carrental.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoderConfig passwordEncoderConfig;
    @GetMapping("/sign-in")
    public String signIn(){

        return "user/sign-in";
    }


    @GetMapping("/sign-up")
    public String signUp(){

        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute UserCreateDto createDto){
        createDto.setPassword(createDto.getPassword());
        System.out.println(createDto);
        return "user/sign-up";
    }

    // todo 1:50 end 

}
