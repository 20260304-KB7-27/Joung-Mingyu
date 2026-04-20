package lecture.ch08.sec11.exam02;

import java.util.Scanner;

public class DriverExample {
    public static void main(String[] args) {
        // 기존버전: 매개값으로 구현 객체 전달 (다형성: 실행 결과가 다름)

        /*
        // Driver 객체 생성
        Driver driver = new Driver();

        // Vehicle 구현 객체 생성
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);
        driver.drive(taxi);
        */


        // 변형버전: 메뉴 제공 후 입력값에 따라
        System.out.println("""
                운전할 차를 선택하세요. 
                1) Taxi
                2) Bus
                """);
        System.out.print("번호 > ");

        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

        Vehicle cars[] = {
            new Taxi(),
            new Bus()
        };

        new Driver().drive(cars[menu - 1]);
    }
}
