package lecture.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        // 인스턴스 내부 객체 생성
        Computer myPc = new Computer(); // 외부 객체 생성
        Computer.CPU myCpu = myPc.new CPU(); // 외부 객체 활용하여 내부 객체 생성

        myCpu.process(); // off -> 연산 불가

        myPc.powerOn(); // 전원 켜짐

        myCpu.process(); // on -> 연산 가능

        // 문제점: 외부 객체를 없앤다고 해도 내부 객체가 살아있을 경우 메모리를 계속 점유
        // 내부 객체 생성 시 숨은 참조(외부 객체) 만들어짐 -> '숨은 참조에 의한 메모리 누수'
        myPc = null;
        myCpu.process();
    }
}
