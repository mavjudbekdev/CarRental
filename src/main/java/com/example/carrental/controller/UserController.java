package com.example.carrental.controller;

import com.example.carrental.config.PasswordEncoderConfig;
import com.example.carrental.dto.UserCreateDto;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

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
        userService.create(createDto);
        return "redirect:/user/sign-in";
    }
  

}
