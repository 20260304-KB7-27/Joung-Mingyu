package basic.ch09.sec02.exam01;

// 인스턴스 내부 클래스 사용법 문제
public class AExample {
    public static void main(String[] args) {
        // 문제: A 객체 생성 (외부 객체)
        A a = new A();

        // 문제: B 객체 생성 (내부 객체)
        A.B b = a.new B();
    }
}