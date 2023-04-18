package chapter7.school;

public class Major {
    String name;
    Subject subject;

    public Major(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }
}
