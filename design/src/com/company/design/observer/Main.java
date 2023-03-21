package com.company.design.observer;

public class Main {
    public static void main(String[] args) {
        Button button = new Button("버튼");
        button.addListener(System.out::println);
        button.click("메시지 전달1");
        button.click("메시지 전달2");
        button.click("메시지 전달3");
        button.click("메시지 전달4");

    }
}
