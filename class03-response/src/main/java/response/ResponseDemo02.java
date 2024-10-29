package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;

@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1获取字节输出流
        ServletOutputStream out = response.getOutputStream();
        //输出数据
        out.write("你不好".getBytes(StandardCharsets.UTF_8));
    }

}
