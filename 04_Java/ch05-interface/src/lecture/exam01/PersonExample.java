package lecture.exam01;

public class PersonExample {
    public static void main(String[] args) {
        // 행동할 수 있는 사람
        Behavior behaviorPerson; // = new Behavior();
        behaviorPerson = /* (Behavior) */new Student(); // 업캐스팅 - 자동 형변환

        behaviorPerson = new Worker(); // 교체
        behaviorPerson.eat();
        behaviorPerson.live();
        behaviorPerson.die();

        Behavior.born();
    }
}
