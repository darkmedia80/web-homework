<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
<style>
  ul li{
    list-style: none;
    float: left;
    margin-top:40px;
  }
  ul li a{
    padding: 20px 50px;
    height: 40px;
    background-color: #85c39c;
    color: #fff;
    box-sizing:border-box;
    margin-right: 10px;
    font-size: 16px;
    text-decoration: none ;
  }
  ul li a:hover{
    background-color: #f57f17;
  }
</style>
</head>
<body>
<h1><%= "设置  Content-type 不同类型资源" %></h1>
<h2><%= "根据不同的参数返回不同的资源" %></h2>
<br/>
<ul>
  <li>
    <a href="responseType?type=img">返回图片</a>
  </li>
  <li>
    <a href="responseType?type=pdf">返回pdf</a>
  </li>
  <li>
    <a href="responseType?type=json">返回json</a>
  </li>
  <li>
    <a href="responseType?type=html">返回网页</a>
  </li>
</ul>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>