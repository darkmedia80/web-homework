package com.example.class02request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*遍历所有请求头数据*/
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name=headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"遍历:"+value);
        }
//        根据名称获取请求头的值
        String header = request.getHeader("user-agent");
        if(header.contains("Edg")){
            System.out.println("Edfe浏览器");
        }else if(header.contains("Firefox")){
            System.out.println("Firefox浏览器");
        }
    }
}
