package org.example.ex03;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

/*
* 쿠키 (Cookie)
* - key-value 쌍으로 클라이언트(브라우저) 쪽에 저장
* - 만료 시간 지정 가능, 정하지 않으면 브라우저가 닫힐 때 사라짐
* - 브라우저가 다음 요청을 보낼 때부터 http 요청에 cookie를 담아 전송
*/
@WebServlet("/cookie-save")
public class CookieSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        // MIME 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        String value = request.getParameter("cookieValue");

        // 쿠키 객체 생성
        Cookie cookie = new Cookie("myCookieData", value);

        // 쿠키 만료 시간 설정
        cookie.setMaxAge(10); // 10초 유지

        response.addCookie(cookie); // 브라우저로 전송

        // Java I/O
        PrintWriter out = response.getWriter();

        // html 작성
        out.println("<html><body>");
        out.println("<h2>Cookie 저장 결과</h2>");
        out.println("<h2>저장 요청한 값: " + value + "</h2>");
        out.println("<a href='session_cookie.jsp'>돌아가기</a>");
        out.println("</body></html>");
    }
}
