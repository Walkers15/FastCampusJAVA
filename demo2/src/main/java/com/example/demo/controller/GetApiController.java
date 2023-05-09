package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 실제로 실무에서 GET 용 api 를 따로 빼거나 하지는 않음!
@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String getHello() {
        return "get hello";
    }

    // 옛날 방식
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String getHi() {
        return "get hi";
    }

    @GetMapping("/path-variable-2/{name}")
    public String pathVariable2(@PathVariable String name) {
        System.out.println("path2  " + " " + name);
        return name;
    }

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String test) {
        System.out.println("path  " + " " + test);
        return test + "입니다!";
    }

    // 쿼리스트링 받기 (by Map)
    // http://localhost:9090/api/get/query-param?user=olaf&email=olaf@ggaa.com&age=25
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParams) {
        StringBuilder sb = new StringBuilder();
        queryParams.forEach((key, value) -> {
            String data = key + " " + value + "\n";
            sb.append(data);
            System.out.print(data);
        });
        return sb.toString();
    }

    // 인자 여러개로 쿼리스트링 받기
    @GetMapping("query-param-2")
    public String queryParam2(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        return String.format("%s %s %d", name, email, age);
    }

    // (추천!) DTO 로 쿼리스트링 받기
    @GetMapping("query-param-3")
    public String queryParam3(UserRequest userRequest) {
        return userRequest.toString() + " 쿼리파라미터 버전 3";
    }
}
