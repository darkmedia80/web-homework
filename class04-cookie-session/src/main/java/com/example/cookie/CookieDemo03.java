package com.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建对象
        String value = "张三";
        Cookie cookie = new Cookie("value", URLEncoder.encode(value, StandardCharsets.UTF_8));

        //cookie存活时间
        cookie.setMaxAge(60*60*24*7);
        cookie.setPath("/");  // 设置路径
        //通过res发送cookie
        response.addCookie(cookie);
    }
}
