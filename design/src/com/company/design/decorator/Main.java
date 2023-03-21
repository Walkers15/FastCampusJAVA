package com.company.design.decorator;

public class Main {
    public static void main(String[] args) {
        ICar audi = new Audi(1000);
        audi.showPrice();

        // audi 등급업
        // a3
        ICar audi3 = new AudiA3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new AudiA4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new AudiA5(audi, "A5");
        audi5.showPrice();
    }
}
