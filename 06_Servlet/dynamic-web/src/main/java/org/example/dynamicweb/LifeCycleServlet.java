package org.example.dynamicweb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

/*
* URL 패턴은 중괄호로 묶어서 여러 개 지정 가능
*/
@WebServlet({"/life-cycle", "/life"})
public class LifeCycleServlet extends HttpServlet {
    // 서블릿 요청될 때마다 호출
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===> SERVICE 호출");
    }

    // 서블릿 컨테이너가 종료될 때 호출
    @Override
    public void destroy() {
        System.out.println("===> DESTROY 호출");
    }

    // 최초 서블릿 요청 시 호출
    @Override
    public void init() throws ServletException {
        System.out.println("===> INIT 호출");
    }
}
