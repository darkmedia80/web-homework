package entity.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;import jakarta.servlet.*;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        HttpServletRequest req = (HttpServletRequest) request;
        String[] urls = {"/images/","/css/","/login.html","/login-page","/generateCaptcha","/login"};
        String requestURI = req.getRequestURI().toString();
        for (String url : urls) {
            if (requestURI.contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/login.html").forward(request,response);
        }
    }


    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}