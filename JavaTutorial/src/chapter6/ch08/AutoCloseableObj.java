package chapter6.ch08;

public class AutoCloseableObj implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseableObj 가 Close 되었습니다.");
    }
}
