package chapter4.ch02;

class Student implements Cloneable {
  private int studentId;
  private String studentName;

  public Student(int studentId, String studentName) {
    this.studentId = studentId;
    this.studentName = studentName;
    System.out.println(this.studentName);
  }

  public boolean equals(Object obj) {
    if (obj instanceof Student) {
      Student std = (Student) obj;
      if (this.studentId == std.studentId)
        return true;
      else
        return false;
    }
    return false;

  }

  @Override
  public int hashCode() {
    return studentId;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }
}