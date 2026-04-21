package basic.ch09.sec02.exam02;

// 인스턴스 내부 클래스 사용 결과 예측 문제
public class AExample {
    public static void main(String[] args) {
        // A 객체 생성 (외부 객체)
        A a = new A();

        // A 인스턴스 메소드 호출
        a.useB();

        /*
            문제: 어떤 결과가 나올지 적어보기
            B-생성자 실행
            1
            B-method1 실행
            2
            B-method2 실행
         */

    }
}