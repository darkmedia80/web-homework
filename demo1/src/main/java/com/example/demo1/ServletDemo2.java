    package com.example.demo1;

    import jakarta.servlet.*;

    import java.io.IOException;
    import java.io.PrintWriter;

    public class ServletDemo2 implements Servlet {
        private String message;
        @Override
        public void init(ServletConfig servletConfig) throws ServletException {
            System.out.println("ServletDemo2 初始化");
            message = "demo2";
        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

        @Override
        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            servletResponse.getWriter().write("ServletDemo2 Service");
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.println("<html>");
            out.println("<head><title>Message</title></head>");
            out.println("<body>");
            out.println("<h1>" + "这是h1渲染下的&nbsp&nbsp&nbsp"+message + "</h1>"); // 使用 HTML 标签渲染 message
            out.println("</body>");
            out.println("</html>");

        }

        @Override
        public String getServletInfo() {
            return "";
        }

        @Override
        public void destroy() {
            System.out.println("ServletDemo2 销毁");
        }
    }
