package servlet;

import entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;


@WebServlet("/login")
public class loginServlet1 extends HttpServlet {
    private UserService userService;

    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("cipher");
        String remember = request.getParameter("remember");
        System.out.println("remember: " + remember);
        System.out.println(account);
        System.out.println(password);
        User user = userService.signIn(account, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("on".equals(remember)) {
                Cookie usernameCookie = new Cookie("account", account);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);
//                if (request.getCookies() != null) {
//                    for (Cookie cookie : request.getCookies()) {
//                        if (cookie.getName().equals("account") && cookie.getValue() != null) {
//                            usernameCookie.setValue(cookie.getValue());
//                        }
//                        if (cookie.getName().equals("password") && cookie.getValue() != null) {
//                            passwordCookie.setValue(cookie.getValue());
//                        }
//                    }
//                }

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("/index");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("<script>alert('账号或密码错误')</script>");
            System.out.println("账号或密码错了");
            System.out.println("Password: " + password);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
