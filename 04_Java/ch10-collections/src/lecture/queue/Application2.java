package lecture.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application2 {
    public static void main(String[] args) {
        /**
         * Deque (덱)
         * - Queue를 확장한 인터페이스로 양쪽 끝에서 모두 삽입 / 삭제 가능
         *
         * 주요 메서드
         * - offerFirst() / offerLast()
         * - peekFirst() / peekLast()
         * - pollFirst() / pollLast()
         */

        Deque<String> dq = new ArrayDeque<>();
        dq.offerLast("middle");
        dq.offerFirst("front");
        dq.offerLast("end");

        System.out.println("dq = " + dq);

        System.out.println("dq.peekFirst() = " + dq.peekFirst());
        System.out.println("dq.peekLast() = " + dq.peekLast());

        System.out.println("dq.pollFirst() = " + dq.pollFirst()); // first
        System.out.println("dq = " + dq);                         // middle end
        System.out.println("dq.pollLast() = " + dq.pollLast());   // end
        System.out.println("dq = " + dq);                         // middle
    }
}
