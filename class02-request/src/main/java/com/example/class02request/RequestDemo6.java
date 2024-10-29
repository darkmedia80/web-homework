package com.example.class02request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("requestDemo6被请求");
     resp.getWriter().write("requestDemo6");
        req.setAttribute("msg","hello");
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("info","hello");

    }

}
