package org.example.frontcontroller.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController {
    // Service
    public String getIndex(HttpServletRequest request, HttpServletResponse response) {
        // service.###()
        // 비즈니스 로직 작성되는 곳

        return "index";
    }
}
