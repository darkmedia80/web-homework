package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("/*")
public class FilterDemo1 implements Filter
    {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            Filter.super.init(filterConfig);
            System.out.println("Filter 初始化");
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            System.out.println("Filter 执行");
        }

        @Override
        public void destroy() {
            System.out.println("demo1执行");
            Filter.super.destroy();
            System.out.println("Filter 销毁");
        }
}
