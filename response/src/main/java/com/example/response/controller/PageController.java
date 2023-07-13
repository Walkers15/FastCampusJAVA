package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/test")
    public String test() {
        return "main.html";
    }

    // 1. ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();
        user.setName("Olaf");
        user.setAddress("Seoul");
        user.setPhoneNumber("010-1234-1111");
        return user;
    }
}
