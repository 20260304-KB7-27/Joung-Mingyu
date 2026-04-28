package lecture.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Application1 {
    public static void main(String[] args) {
        /**
         * Queue
         *
         * 주요 메서드
         * - offer(): 요소 추가(실패했을 때 false 반환) (add()는 예외 발생)
         * - peek(): 가장 앞 요소 반환
         * - poll(): 가장 앞 요소 반환 후 제거
         */

        Queue<String> q = new LinkedList<>();

        q.offer("first");
        q.offer("second");
        q.offer("third");

        System.out.println("q.peek() = " + q.peek());
        System.out.println("q.poll() = " + q.poll()); // 앞 요소 꺼내고 제거
        System.out.println("q.peek() = " + q.peek());
    }
}
