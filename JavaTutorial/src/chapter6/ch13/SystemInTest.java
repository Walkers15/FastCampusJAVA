package chapter6.ch13;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {
    public static void main(String[] args) {
        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");

        int i;
        try {
            // 바이트를 문자로 바꿔주는 클래스
            // 한글을 입력해도 안 깨짐!
            // System.in.read 는 깨짐
            InputStreamReader irs = new InputStreamReader(System.in);
            while( (i = irs.read()) != '\n' ) {
                System.out.print((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
