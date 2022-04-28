package chapter2.ch04;

public class StudentTest {

    public static void main(String[] args) {
        Student studentBaek = new Student();

        studentBaek.studentID = 12345;
        studentBaek.setStudentName("백승훈");

        studentBaek.address = "즐거운 우리 집";

        studentBaek.showStudentInfo();

        Student studentKim = new Student();

        studentKim.setStudentName("김준식");
        studentKim.address = "강남역 1번출구";
        studentKim.studentID = 11213;

        studentKim.showStudentInfo();


        System.out.println(studentBaek);
        System.out.println(studentKim);
    }
}
