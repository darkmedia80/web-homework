package practise;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class downloadServelt extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletOutputStream out = response.getOutputStream();
        String realPath = request.getServletContext().getRealPath("/img/" + filename);
        FileInputStream f = new FileInputStream(realPath);
        String mimeType = request.getServletContext().getMimeType(filename);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        ServletOutputStream out2 = response.getOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int length = 0;
        while ((length = f.read(buffer)) != -1) {
            out2.write(buffer, 0, length);
        }
        f.close();
    }
}



