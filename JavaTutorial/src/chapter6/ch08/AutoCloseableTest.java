package chapter6.ch08;

public class AutoCloseableTest {
    public static void main(String[] args) {

        try(AutoCloseableObj obj = new AutoCloseableObj()) {
            throw new Exception("test");
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        }

        System.out.println("End of Main");
    }
}
