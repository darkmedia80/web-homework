package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class sensitiveWordFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感文字.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close(); // 关闭BufferedReader
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");

        // 创建代理对象
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(
                servletRequest.getClass().getClassLoader(),
                servletRequest.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 处理请求参数
                        if (args != null && args.length > 0) {
                            for (int i = 0; i < args.length; i++) {
                                if (args[i] instanceof String) {
                                    String value = (String) args[i];
                                    for (String s : list) {
                                        if (value.contains(s)) {
                                            value = value.replace(s, "****");
                                        }
                                    }
                                    args[i] = value; // 替换后的值
                                }
                            }
                        }
                        return method.invoke(servletRequest, args);
                    }
                }
        );

        // 继续过滤链
        filterChain.doFilter(proxyReq, servletResponse);
    }
}