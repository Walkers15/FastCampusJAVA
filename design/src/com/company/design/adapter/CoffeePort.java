package com.company.design.adapter;

public class CoffeePort implements Electronic110V {

    @Override
    public void powerOn() {
        System.out.println("COFFEE PORT 110V POWER ON");
    }

    @Override
    public void powerOff() {

    }
}
