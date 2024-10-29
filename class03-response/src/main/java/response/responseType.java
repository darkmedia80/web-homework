package response;

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

@WebServlet("/responseType")
public class responseType extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "img":
                getimage(req, resp);
                break;
            case "pdf":
                getpdf(req, resp);
                break;
            case "json":
                getJson(req, resp);
                break;
            case "html":
                getHtml(req, resp);
            default:
                break;
        }
    }

    private void getimage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        String realPath = req.getServletContext().getRealPath("/");
        File f = new File(realPath+"/img/picture.png");
        InputStream is = new FileInputStream(f);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = is.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }
    private void getpdf(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        String realPath = req.getServletContext().getRealPath("/");
        File f = new File(realPath+"/pdf/java填空题汇总.pdf");
        InputStream is = new FileInputStream(f);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = is.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }
    private void getJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path + "/json/j.json");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);

        }
        out.flush();
        out.close();
    }
    private void getHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path + "/html/04_粘性定位.html");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);

        }
        out.flush();
        out.close();
    }


}
