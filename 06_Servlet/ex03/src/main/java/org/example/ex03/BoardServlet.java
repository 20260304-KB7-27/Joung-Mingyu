package org.example.ex03;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.Enumeration;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        
        // MIME 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        Enumeration<String> enu = request.getParameterNames();

        // Java I/O
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        while (enu.hasMoreElements()) {
            // parameter key 목록에서 1개만 꺼냄
            String name = enu.nextElement();

            // request에서 name에 맞는 value 찾기
            String value = request.getParameter(name);

            out.print(name + " : " + value);
        }

        out.println("</body></html>");
    }
}
