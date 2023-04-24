package chapter7.school;

import java.util.ArrayList;

public class Professer {
    Subject subject;
    ArrayList<Score> scores = new ArrayList<>();

    public Professer(Subject subject) {
        this.subject = subject;
    }

    /**
     * 교수가 수강신청 한 학생을 점수 받을 목록에 추가
     * @param student 수강신청한 학생
     */
    public void addStudentToClass(Student student) {
        Score score;
        if (student.major.subject == this.subject) {
            score = new Score(student, this.subject, new MajorEvaluation());

        } else {
            score = new Score(student, this.subject, new BasicEvaluation());
        }
        this.scores.add(score);
        student.addScore(score);
    }


    public void calculateGrade(int[] points) {
        for (int i = 0; i < points.length; i++) {
            this.scores.get(i).setGrade(points[i]);
        }
    }
}
