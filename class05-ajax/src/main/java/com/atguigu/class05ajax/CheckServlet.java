package com.atguigu.class05ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkservlet")
public class CheckServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    从客户端上获取用户名
    String name = req.getParameter("username");
    boolean flag = !"admin".equals(name);
    System.out.println(name);
    resp.getWriter().write(String.valueOf(flag));

}
}
