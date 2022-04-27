package ch13;

import java.util.Scanner;

public class ConditionTest {
    public static void main(String[] args) {

        int max;
        System.out.println("두 수를 입력받아 더 큰 수를 출력합니다\n");
        Scanner scanner = new Scanner(System.in);

        int inputNumA = scanner.nextInt();
        int inputNumB = scanner.nextInt();
        System.out.println(inputNumA > inputNumB ? inputNumA : inputNumB);
    }
}
