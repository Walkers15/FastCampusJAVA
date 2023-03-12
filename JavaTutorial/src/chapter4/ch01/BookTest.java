// Object.toString Override
package chapter4.ch01;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("지대녋얕", "채사장");
        System.out.println(book.toString());
    }
}
