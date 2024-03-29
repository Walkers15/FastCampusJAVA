package com.example.aop.controller;

import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        String result = id + " " + name;
        System.out.println(result);
        return result;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic
        Thread.sleep(1592);
    }
}
