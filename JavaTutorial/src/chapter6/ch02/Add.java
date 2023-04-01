package chapter6.ch02;

@FunctionalInterface
public interface Add {
    // 람다 표현식
    // 익명 함수와 매개 변수만으로 구현되므로 인터페이스는 단 하나의 메서드만을 선언해야함!!
    int add(int x, int y);
}
