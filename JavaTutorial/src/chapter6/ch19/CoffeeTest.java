package chapter6.ch19;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee ethiopiaCoffee = new EthiopiaAmericano();
        ethiopiaCoffee.brewing();

        System.out.println();

        Latte ethiopiaLatte = new Latte(ethiopiaCoffee);
        ethiopiaLatte.brewing();

        System.out.println();

        Mocha ethiopiaMocha = new Mocha(ethiopiaLatte);
        ethiopiaMocha.brewing();

        System.out.println();

        new Mocha(ethiopiaMocha).brewing();

        System.out.println();

        new Latte(new Mocha(ethiopiaMocha)).brewing();

        System.out.println();

        new Mocha(new Latte(new KennaEspresso())).brewing();
    }
}
