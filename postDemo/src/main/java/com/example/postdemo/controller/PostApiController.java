package com.example.postdemo.controller;

import com.example.postdemo.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public String post(@RequestBody PostRequestDTO requestData) {
        System.out.println(requestData.toString());
        return requestData.toString();
    }
}
