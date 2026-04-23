package ch12.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
         * Reflection
         * 프로그램이 실행되는 동안(런타임)에 클래스의 정보를 꺼내보고 실행도 시킬 수 있는 기능
         *
         * Spring 프레임워크 내부에서 @Controller @Autowired를 처리할 때
         */

        Class car = Car.class;

        System.out.println("생성자 정보");

        // 모든 생성자 조회
        Constructor[] constructors = car.getDeclaredConstructors();

        Car car2 = (Car) constructors[1].newInstance();
        car2.drive();

        Field[] fields = car.getDeclaredFields(); // private도 가져옴
        Field[] fields2 = car.getFields(); // public만 가져옴

        for (Field field : fields) {
            System.out.println(field.getType().getName() + " field = " + field.getName());
        }

    }
}
