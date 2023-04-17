package chapter6.ch23;

import java.util.ArrayList;

class FastLibrary {
    public ArrayList<String> shelf = new ArrayList<>();

    public FastLibrary() {
        shelf.add("호랑이 형님 1권");
        shelf.add("호랑이 형님 2권");
//        shelf.add("호랑이 형님 3권");
/*
        shelf.add("호랑이 형님 4권");
        shelf.add("호랑이 형님 5권");
        shelf.add("호랑이 형님 6권");
*/

    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (shelf.size() == 0) {
            System.out.println(t.getName() + " go to sleep");
            wait();
            System.out.println(t.getName() + " wake up!");
        }

        String book = shelf.remove(0);
        System.out.println(t.getName() + " Get " + book);

        return book;
    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();

        shelf.add(book);
        notifyAll();

        System.out.println(t.getName() + " Return " + book);
    }
}

class Student extends Thread {
    public String name;

    public Student(String name) {
        super(name);
        this.name = name;
    }

    public void run() {

        try {
            String book = LibraryMain.library.lendBook();
            if (book == null) {
                return;
            }

            sleep(5000);

            LibraryMain.library.returnBook(book);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class LibraryMain {

    public static FastLibrary library = new FastLibrary();

    public static void main(String[] args) {
        Student std1 = new Student("kim");
        Student std2 = new Student("kim2");
        Student std3 = new Student("kim3");
        Student std4 = new Student("kim4");
        Student std5 = new Student("kim5");
        Student std6 = new Student("kim6");

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
        std6.start();
    }
}
