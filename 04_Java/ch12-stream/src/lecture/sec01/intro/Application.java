package lecture.sec01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /**
         * 1. 데이터 소스
         * - 스트림이 데이터를 가져오게 하는 시작점
         *
         * 2. 중간 연산
         * - 데이터를 가공하는 단계
         * - 항상 새로운 stream을 반환
         * - 지연 실행(Lazy) -> 최종 연산 전까지 수행 안됨.
         *
         * 3. 최종 연산
         * - 스트림 처리를 종료하고 결과를 만든다. (스트림 전체가 실행)
         * - 실행 이후 스트림 재사용 불가
         */
        List<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "stream"));
        stringList.stream() // 스트림
                .filter(s -> s.length() < 6) // 중간 연산
                // .forEach(System.out::println);
                .forEach(s -> System.out.println(s)); // 최종 연산
    }
}
