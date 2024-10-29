package response;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置响应码
        response.setStatus(200);
        //2设置响应头
        response.setHeader("location", "/responseDemo02");
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //设置相应结果
        response.getWriter().write("你好");
    }
}
