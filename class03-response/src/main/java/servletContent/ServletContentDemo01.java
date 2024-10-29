package servletContent;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.StringReader;

public class ServletContentDemo01 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servlet对象
        ServletContext context = req.getServletContext();
        //获取文件名
        String filename = "hello.pdf";
        //获取资源文件类型
        String mineType = getServletContext().getMimeType(filename);
        System.out.println(mineType);
    }
}
