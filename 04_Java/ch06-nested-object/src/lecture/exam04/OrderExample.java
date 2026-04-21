package lecture.exam04;

public class OrderExample {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        // 상황1. 할인 정책 없음 -> policy 필드가 null인 상태
        processor.orderProcess(10000);

        // 상황2. 봄맞이 이벤트로 전품목 2000원 할인
        processor.setDiscountPolicy(new OrderProcessor.DiscountPolicy() {
            @Override
            public int applyDiscount(int price) {
                return price - 2000;
            }
        });

        // 상황3. 50% 할인
        processor.setDiscountPolicy(new OrderProcessor.DiscountPolicy() {
            @Override
            public int applyDiscount(int price) {
                return price / 2;
            }
        });

        // 주문 처리기 정의시에는 흐름만 정의
        // 할인 계산 방식은 외부에서 주입받기
        // -> 할인 정책이 상황별로 바뀌어도 OrderProcessor 코드는 수정하지 않음
    }
}
