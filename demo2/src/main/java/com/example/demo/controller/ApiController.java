package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class 는 Rest Api 를 처리하는 Controller 로 등록됨 (스프링에서 자동인식)
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello") // GET /api/hello 요청시 이쪽으로 요청이 들어옴
    public String hello() {
        return "Hello Spring Boot!";
    }
}
