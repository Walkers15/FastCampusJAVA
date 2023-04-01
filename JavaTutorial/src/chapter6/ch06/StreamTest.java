package chapter6.ch06;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();

        sList.add("Tom");
        sList.add("Juan");
        sList.add("Ted");

        sList.forEach(System.out::println);

        sList.stream().map(String::length).forEach(l -> System.out.print(l + "\t"));
    }
}
