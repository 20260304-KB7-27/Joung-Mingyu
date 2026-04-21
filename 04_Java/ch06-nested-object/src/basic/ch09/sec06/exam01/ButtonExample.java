package basic.ch09.sec06.exam01;

// 로컬 클래스 정의 방법 문제
public class ButtonExample {
    public static void main(String[] args) {
        // 문제: Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스 (로컬 클래스)
        class OkListener implements Button.ClickListener {

            @Override
            public void onClick() {
                System.out.println("ok 버튼이 클릭되었습니다.");
            }
        }

        OkListener okListener = new OkListener();
        okListener.onClick();
    }
}