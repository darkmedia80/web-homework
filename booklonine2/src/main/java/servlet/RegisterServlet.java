package servlet;

import entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("cipher");
        String verifyCode = req.getParameter("captcha");//获取表单验证码

        HttpSession session = req.getSession();//获得session对象
        String sessionVerifyCode = session.getAttribute("captcha").toString();//获得session对象中的验证码

        if(sessionVerifyCode.equals(verifyCode)){//如果匹配成功
            //调用注册功能
           int user = userService.register(account, password);
            //将用户对象写入数据库
            if (user ==1) {
                //注册成功，跳转登录界面
                //重定向回到/login-page，进入LoginServlet
                resp.sendRedirect("/login.html");
            } else {
                //注册失败，设置好响应对象字符集和响应类型
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('注册失败！');location.href='/register-Page';</script>");
            }
        }else{//匹配失败
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('验证码错误！');location.href='/register-Page';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
