package com.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies){
        if("value".equals(cookie.getName())){
            String v = cookie.getValue();
            String valuename = URLDecoder.decode(v, StandardCharsets.UTF_8);
            System.out.println("用户名"+valuename);
        }
    }
}
}
