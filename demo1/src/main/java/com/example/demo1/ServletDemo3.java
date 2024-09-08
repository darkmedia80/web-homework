package com.example.demo1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "demo3",value = "/ServletDemo3",loadOnStartup = 2)

public class ServletDemo3 implements Servlet {
    private String message;
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo3 初始化");
        message="demo3";
    }


    public ServletConfig getServletConfig() {
        return null;
    }


    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("ServletDemo3 Service");
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head><title>Message</title></head>");
        out.println("<body>");
        out.println("<h1>" + "这是h1渲染下的&nbsp&nbsp&nbsp"+message + "</h1>"); // 使用 HTML 标签渲染 message
        out.println("</body>");
        out.println("</html>");
    }


    public String getServletInfo() {
        return "";
    }


    public void destroy() {
        System.out.println("ServletDemo3 销毁");
    }
}
