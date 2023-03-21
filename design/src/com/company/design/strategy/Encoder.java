package com.company.design.strategy;

public class Encoder {
    EncodingStrategy encodingStrategy;

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }

    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }
}
