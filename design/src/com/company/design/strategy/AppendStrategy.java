package com.company.design.strategy;

public class AppendStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return "ABC" + text;
    }
}
