package basic.ch13.lecture;

public class Application {
    public static void main(String[] args) {
        // 요청이 들어온 상태

        // 서비스 로직
        User user = new User("kim", 20);
        System.out.println(user);

        // Controller
        ApiResponse<User> response = ApiResponse.ok(user);
        ApiResponse<String> response2 = ApiResponse.ok("문자열 응답 데이터");

        System.out.println(response); // api 요청한 곳에서 응답받는 객체
        System.out.println(response2); // api 요청한 곳에서 응답받는 객체
    }

//    @GetMapping("/user/1")
//    public ApiResponse<User> getUser() {
//        User user = new User("kim", 20);
//
//        return ApiResponse.ok(user);
//    }
}
