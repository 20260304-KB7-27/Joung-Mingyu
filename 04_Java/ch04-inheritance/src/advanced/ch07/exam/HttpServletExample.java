package advanced.ch07.exam;

public class HttpServletExample {
    public static void main(String[] args) {
        //          o                       x
        // HttpServlet servlet; // = new HttpServlet();
        method(new LoginServlet()); // 로그인 합니다.
        method(new FileDownloadServlet()); // 파일 다운로드합니다
    }

    public static void method(HttpServlet httpServlet) { // 매개변수의 다형성
        httpServlet.service(); // 동적 바인딩
    }
}
