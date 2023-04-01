package chapter6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {
    public static void main(String[] args) {

        // FileInputStream 은 AutoCloseable 를 상속받아 구현했으므로 알아서 close 됨
        try(FileInputStream fis = new FileInputStream("a.txt")) {
            System.out.println("Read File");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of Main");
    }
}
