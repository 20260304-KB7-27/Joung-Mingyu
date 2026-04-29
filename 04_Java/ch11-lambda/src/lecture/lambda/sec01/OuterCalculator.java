package lecture.lambda.sec01;

public interface OuterCalculator {
    /**
     * 내부 인터페이스
     * - 기본적으로 public static 속성을 가짐
     * 바깥클래스명.내부인터페이스명 으로 접근
     */
    @FunctionalInterface
    interface Sum {
        int sum(int a, int b);
    }

    @FunctionalInterface
    interface Minus {
        int minus(int a, int b);
    }

    @FunctionalInterface
    interface Multiple {
        int multiple(int a, int b);
    }

    @FunctionalInterface
    interface Divide {
        int divide(int a, int b);
    }
}
