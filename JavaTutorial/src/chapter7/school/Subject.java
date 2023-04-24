package chapter7.school;

import java.util.ArrayList;

public class Subject {
    String name;
    int subjectId;
    ArrayList<Student> students = new ArrayList<>();

    public Subject(String name, int subjectId) {
        this.name = name;
        this.subjectId = subjectId;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
