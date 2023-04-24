package chapter7.school;

import java.util.ArrayList;

public class GoodSchool {
    public static void main(String[] args) {
        Subject korean = new Subject("국어", 1);
        Subject math = new Subject("수학", 2);

        Professer kim = new Professer(korean);
        Professer lee = new Professer(math);

        Major kor = new Major("국어국문학과", korean);
        Major cse = new Major("컴퓨터공학과", math);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(211213, "강감찬", kor));
        students.add(new Student(212330, "김유신", cse));
        students.add(new Student(201518, "신사임당", kor));
        students.add(new Student(202360, "이순신", kor));
        students.add(new Student(201290, "홍길동", cse));

        // 수강신청
        students.forEach(student -> {
            kim.addStudentToClass(student);
            lee.addStudentToClass(student);
        });

        int[] korScore = {95, 95, 99, 89, 85};
        int[] mathScore = {56, 98, 88, 95, 56};

        kim.calculateGrade(korScore);
        lee.calculateGrade(mathScore);

        // 국어영억 성적 출력
        StringBuilder korReport = new StringBuilder();
        korReport.append("국어 수강생 학점\n");
        korReport.append(String.format("%-10s\t학번\t%-10s\t점수\n", "이름", "중점과목"));
        korReport.append("------------------------------------------------\n");

        StringBuilder mathReport = new StringBuilder();
        mathReport.append("수학 수강생 학점\n");
        mathReport.append(String.format("%-10s\t학번\t%-10s\t점수\n", "이름", "중점과목"));
        mathReport.append("------------------------------------------------\n");

        students.forEach(student -> student.scores.forEach(score -> {
            if (score.subject.subjectId == 1) {
                korReport.append(score.getGradeFormat());
            } else {
                mathReport.append(score.getGradeFormat());
            }
        }));

        System.out.println(korReport);

        System.out.println();

        System.out.println(mathReport);
    }
}
