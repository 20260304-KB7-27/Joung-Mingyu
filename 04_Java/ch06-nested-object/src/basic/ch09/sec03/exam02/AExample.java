package basic.ch09.sec03.exam02;

// 정적 내부 클래스 사용법 문제
public class AExample {
    public static void main(String[] args) {
        // 문제: B 객체 생성 및 인스턴스 필드 및 메소드 사용
        A.B b = new A.B();
        System.out.println(b.field1); // 인스턴스 필드
        b.method1(); // 인스턴스 메소드
        // 문제: B 클래스의 정적 필드 및 메소드 사용
        System.out.println(A.B.field2);
        A.B.method2();
    }
}