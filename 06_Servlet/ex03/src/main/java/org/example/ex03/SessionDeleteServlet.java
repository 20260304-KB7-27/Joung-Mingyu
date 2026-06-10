package org.example.ex03;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet("/session-delete")
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // MIME 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        // 세션에서 키에 해당하는 데이터 삭제
        session.removeAttribute("mySessionData");

        // 세션 전체 삭제
        session.invalidate();

        // Java I/O
        PrintWriter out = response.getWriter();

        // html 작성
        out.println("<html><body>");
        out.println(" 삭제 완료 <br>");
        out.println("<a href='session_cookie.jsp'>돌아가기</a>");
        out.println("</body></html>");
    }
}
