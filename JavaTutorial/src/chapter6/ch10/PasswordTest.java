package chapter6.ch10;

public class PasswordTest {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        if (password == null) {
            throw new PasswordException("비밀번호는 NULL 일 수 없습니다.");
        } else if (password.length() < 5) {
            throw new PasswordException("비밀번호는 5자리 이상이어야 합니다.");
        } else if (password.matches("[a-zA-z]+")) {
            throw  new PasswordException("비밀번호는 특수문자를 포함하여야 합니다.");
        }
        this.password = password;
    }

    public static void main(String[] args) {
        PasswordTest test = new PasswordTest();

        String password = null;

        try {
            test.setPassword(password);
            System.out.println("오류 없음");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abc";
        try {
            test.setPassword(password);
            System.out.println("오류 없음2");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abide";
        try {
            test.setPassword(password);
            System.out.println("오류 없음3");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abide#1";
        try {
            test.setPassword(password);
            System.out.println("오류 없음4");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
