package servletContent;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@WebServlet("/servletContextDemo04")
public class servletContentDemo04 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String patha = servletContext.getRealPath("/a.txt");
        System.out.println("a的文件地址"+patha);
        String pathb = servletContext.getRealPath("WEB-INF/b.txt");
        System.out.println("b.txt文件地址"+pathb);
        String pathc = servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println("c.txt文件地址"+pathc);
        File f = new File(pathc);
        InputStream is = new FileInputStream(f);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = is.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }
}
