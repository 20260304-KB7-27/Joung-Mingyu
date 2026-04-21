package lecture.exam03;

public class AnimalExample {
    public static void main(String[] args) {
        // 멍멍 짖는 강아지 필요함

        // 방법1. Animal을 상속받아 완성하는 Dog 클래스를 만들어서 생성
        // 방법2. 지금 당장에서만 필요할 경우 여기서 바로 완성시킨 후 생성
        Animal dog = new Animal() {
            @Override
            public void sound() {
                System.out.println("멍멍");
            }
        };

        dog.sound();

        Animal cat = new Animal() {
            @Override
            public void sound() {
                System.out.println("야옹");
            }
        };

        cat.sound();

        // 인터페이스도 동일
        // 단, 추상 메서드가 1개라면 -> 익명 클래스 방식보다 람다 선호
    }
}
