package lecture.sec03;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 주입
        UserService service = new UserService();

        // 전체 조회
        List<User> users = service.getUsers();
        // users.forEach(u -> System.out.println(u));

        // 단일 조회
        User user = service.getUserById(1L);
        System.out.println(user);

        try {
            User user2 = service.getUserById(99L);
            System.out.println(user2);
        } catch (Exception e) {
            System.out.println("[예외]: " + e.getMessage());
        }

        service.printIfExist(3L);

        // 이메일
        String email = service.getEmail(1L);
        String email2 = service.getEmail(2L);
        System.out.println(email);
        System.out.println(email2);
    }
}
