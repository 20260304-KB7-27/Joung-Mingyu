package lecture.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application3 {
    public static void main(String[] args) {
        /**
         * PriorityQueue 우선순위 큐
         * - FIFO이 아니라 우선 순위가 높은 요소부터 꺼냄
         * - Comparable, Comparator 정렬 기준을 변경할 수 있음 (우선순위 지정 가능)
         */

        // 숫자형 기본: 오름차순
        // Collections.reverseOrder(): 기본 정렬의 역순 Comparator
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(30);
        pq.offer(10);
        pq.offer(50);
        pq.offer(20);
        pq.offer(40);

        System.out.println("pq = " + pq); // 정렬 순서는 아님 메모리상 구조

        // 작은 숫자부터 꺼냄 (우선순위 기준)
        while (!pq.isEmpty()) {
            System.out.println("pq.poll() = " + pq.poll());
        }
    }
}
