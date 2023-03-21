package com.company.design.adapter;

public class Main {
    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }

    public static void main(String[] args) {
        CoffeePort coffeePort = new CoffeePort();
        connect(coffeePort);

        Cleaner cleaner = new Cleaner();
        // connect(cleaner); // 불가능! 우리집은 110V connect 만 있으므로

        // 어뎁터를 이용하여 호환되지 않는 인터페이스를 호환 가능하도록 변경
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airConditionerAdapter = new SocketAdapter(airConditioner);
        connect(airConditionerAdapter);

    }
}
