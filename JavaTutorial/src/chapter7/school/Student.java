package chapter7.school;

import java.util.ArrayList;

public class Student {
    int studentId;
    String name;
    Major major;


    ArrayList<Score> scores = new ArrayList<>();

    public Student(int studentId, String name, Major major) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
    }

    public void addScore(Score score) {
        this.scores.add(score);
    }
}
