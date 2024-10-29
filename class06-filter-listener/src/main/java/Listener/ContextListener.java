package Listener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.HashMap;
import java.util.Map;
@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener,HttpSessionAttributeListener{
    private static Map<String,Object>sessionMap;
    public void ContextListener() {

    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized");
        sessionMap = new HashMap<String, Object>(8);
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Context Destroyed");
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        sessionMap.remove(session.getId());
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed");
    }
}
