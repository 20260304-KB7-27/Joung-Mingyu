package lecture.sec02.generation;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {
        // 배열
        String[] sArr = {"java", "mysql", "jdbc"};

        // 시작 인덱스 끝 인덱스 (포함 X)
        Stream<String> strStream = Arrays.stream(sArr, 0, 2);
        strStream.forEach(System.out::println);

        Stream<String> builderStream = Stream.<String> builder()
                .add("홍길동")
                .add("유관순")
                .add("윤봉길")
                .build();
    }
}
