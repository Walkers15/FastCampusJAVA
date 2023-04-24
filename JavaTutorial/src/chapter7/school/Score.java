package chapter7.school;

public class Score {
    Student student;
    Subject subject;
    int point;
    GradeEvaluation evaluation;
    private char grade;

    public Score(Student student, Subject subject, GradeEvaluation evaluation) {
        this.student = student;
        this.subject = subject;
        this.evaluation = evaluation;
    }

    public void setGrade(int point) {
        this.point = point;
        this.grade = this.evaluation.getGrade(point);
    }

    public String getGradeFormat() {
        return String.format("%-10s\t%d\t%s\t%d:%c\n", this.student.name, this.student.studentId, this.student.major.name, this.point, this.grade);
    }
    
}
