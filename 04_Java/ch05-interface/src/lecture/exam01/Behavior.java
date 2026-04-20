package lecture.exam01;

/**
 * 인터페이스
 * 1. 기본적으로 추상 메서드와 상수 필드만 가질 수 있는 크래스의 변형체
 *     -> 필드 작성 시 묵시적으로 public static final
 *     -> 메서드 작성 시 묵시적으로 public abstract
 * 2. 클래스에서 인터페이스 구현 시 implements 키워드 사용
 */
public interface Behavior {
    // 일반 필드 불가
    // private int num;

    // 상수 필드 가능
    /* public static final */ int OPENING_TIME = 9;
    /* public static final */ int CLOSING_TIME = 18;

    // 일반 메서드 불가
    // public void basicMethod() {}

    // 추상 메서드 가능
    /* public abstract */ void eat();
    /* public abstract */ void live();

    // void die();

    // default 메서드로 구현부가 구현부가 정의되어 있는 메서드 정의 가능
    // 구현 클래스에서 선택적으로 오버라이딩 가능
    default void die() {
        System.out.println("우리는 언젠가 죽게 되어있습니다.");
    }

    // static 메서드로 공통 메서드 정의 가능
    // 구현 클래스에서 오버라이딩 불가능
    static void born() {
        System.out.println("우리는 모두 엄마 뱃속에서 태어납니다.");
    }
}
