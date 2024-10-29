package servlet;

import entity.Book;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BookService;
import service.BookServiceImpl;

import java.io.IOException;
@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getRequestURI().trim();
        int position = requestPath.lastIndexOf("/");
        String id = requestPath.substring(position + 1);
        Book book = bookService.getBookById(Integer.parseInt(id));
        request.setAttribute("book",book);
        request.getRequestDispatcher("/book_detail.jsp").forward(request, response);
    }
}
