package com.example.class02request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        System.out.println("用户名"+username);
        String[] hobbies = req.getParameterValues("hobbies");
        for(String hobby:hobbies){
            System.out.println(hobby);
        }
        System.out.println("---------------------------------------");
        System.out.println("要获取所有请求的参数名称");
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            System.out.println("参数名称"+name);
            String value = req.getParameter(name);
            System.out.println("参数值"+value);
        }
        //获取所有的参数的Map集合
        System.out.println("----------------------------------------");
        System.out.println("获取所有请求的map集合");
        Map<String,String[]> map = req.getParameterMap();
        //遍历获取
        Set<String> keyset=map.keySet();
        for(String name:keyset){
            System.out.println("参数名称"+name);
            String[] values = map.get(name);
            for(String value:values){
                System.out.println("参数值"+value);
            }
        }
    }
}
