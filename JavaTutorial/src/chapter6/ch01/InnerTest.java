package chapter6.ch01;

class OutClass {
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;

    public OutClass() {
        this.inClass = new InClass();
    }

    class InClass {
        int inNum = 100;

        // static int sInNum = 500; 오류! Outer Class 가 생성 이후 Inner Class 가 생성되므로 Static 선언 불가능

        void inTest(){
            System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
        }
    }

    public void usingClass() {
        inClass.inTest();
    }

    static class InStaticClass {

        int inNum = 100;
        static int sInNum = 200;

        void inTest(){   //정적 클래스의 일반 메서드
            // num += 10;    // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
            System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");
        }

        static void sTest(){  // 정적 클래스의 static 메서드
            // num += 10;   // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
            // inNum += 10; // 내부 클래스의 인스턴스 변수는 사용할 수 없음

            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");

        }
    }
}
public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();

        // 내부 클래스가 private 이 아닌 경우 이런 식으로 외부에서도 사용 가능함
        OutClass.InClass inner = outClass.new InClass();
        inner.inTest();
        System.out.println();

        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest();
        System.out.println();
        OutClass.InStaticClass.sTest();
    }
}
