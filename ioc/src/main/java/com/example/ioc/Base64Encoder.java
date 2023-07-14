package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("괙")
public class Base64Encoder implements IEncoder {
    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
