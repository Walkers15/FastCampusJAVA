package com.company.design.strategy;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        EncodingStrategy base64 = new Base64Strategy();
        EncodingStrategy normal = new NormalStrategy();
        EncodingStrategy append = new AppendStrategy();

        String message = "안녕하세요 자바!";

        encoder.setEncodingStrategy(base64);
        System.out.println(encoder.getMessage(message)); // 7JWI64WV7ZWY7~~

        encoder.setEncodingStrategy(normal);
        System.out.println(encoder.getMessage(message)); // 안녕하세요 자바!

        encoder.setEncodingStrategy(append);
        System.out.println(encoder.getMessage(message)); // ABC안녕하세요 자바!
    }
}
