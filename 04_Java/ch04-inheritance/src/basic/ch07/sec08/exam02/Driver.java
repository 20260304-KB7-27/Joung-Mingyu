package basic.ch07.sec08.exam02;

public class Driver {
    // 메서드 -> 의존 관계
    // 개방 폐쇄 법칙
    // 확장에는 열려 있고 수정에는 닫혀 있는 구조
    public void drive(Vehicle vehicle) {
        vehicle.run();

    }
}
