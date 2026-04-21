package basic.ch09.sec07.exam02;

public class Home {

    // 문제: use1 메소드 실행시 기대값이 출력될 수 있도록
    //       익명 구현 객체를 생성하여 필드에 대입하시오.
    private RemoteControl rc = new RemoteControl() {

        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };

    public void use1() {
        rc.turnOn();
        rc.turnOff();
        /*
            실행 기대값
            TV를 켭니다.
            TV를 끕니다.
         */
    }
}