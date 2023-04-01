package chapter6.ch02;

public class LambdaTest {
    public static void main(String[] args) {

        Add addL = ((x, y) -> x + y);
//        Add add2 = (Integer::sum); // 람다를 메서드 참조로 변경

        System.out.println(addL.add(2, 3));
//        System.out.println(add2.add(3, 7));

        MyNumber compare = (x, y) -> Math.max(x, y);
        System.out.println(compare.getMax(125, 123));
        System.out.println(compare.getMax(121, 1123));
//        MyNumber compare2 = (Math::max);
    }
}
