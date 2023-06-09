package com.example.putdemo;

import com.example.putdemo.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(requestDto);
        System.out.println(id);
        return requestDto;
    }
}
