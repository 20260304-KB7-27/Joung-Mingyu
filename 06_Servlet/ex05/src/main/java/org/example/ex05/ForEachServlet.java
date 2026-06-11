package org.example.ex05;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.ex05.domain.Member;

import java.io.*;
import java.util.*;

@WebServlet("/jstl2")
public class ForEachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = new ArrayList<>();

        members.add(new Member("홍길동", "hong"));
        members.add(new Member("김철수", "kkim"));
        members.add(new Member("이영희", "ee20"));

        request.setAttribute("memberList", members);

        request.getRequestDispatcher("jstl/forEach.jsp").forward(request, response);
    }
}
