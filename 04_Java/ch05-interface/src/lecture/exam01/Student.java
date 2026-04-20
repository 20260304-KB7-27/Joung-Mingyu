package lecture.exam01;

public class Student extends Person implements Behavior { // + name, age
    // 추가적인 필드
    String schoolName;
    int grade;

    // 먹고, 생활하는
    @Override
    public void eat() {
        System.out.println("학교에서 급식을 먹습니다.");
    }

    @Override
    public void live() {
        System.out.println(OPENING_TIME + "시부터 " + CLOSING_TIME + "시까지 학교에서 수업을 듣습니다.");
    }
}
