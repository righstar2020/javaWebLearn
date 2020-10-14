<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie"%>
<html>

<head>
    <style>
        body {
            padding: 0;
            margin: 0;
            background-color: #fefefe;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .container {
            width: 340px;
            height: auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid gainsboro;
        }
        
        .container .d1 {
            color: darkgoldenrod;
            font-size: 25px;
            width: 100%;
            margin: 15px 10px;
        }
        
        .container .d2 {
            font-size: 13px;
            width: 100%;
            margin: 15px 10px;
        }
        
        .container .registerForm {
            width: 80%;
            height: auto;
            border: 1px dotted #0e0e0e;
            padding: 0 20px;
            margin: 15px auto;
            padding: 40px 5px;
            padding-top: 5px;
            position: relative;
        }
        
        .registerForm .title {
            font-size: 12px;
            padding: 2px;
            color: #fff;
            background-color: darkgoldenrod;
            width: 100px;
            margin-left: 10px;
            margin-top: -12px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .registerForm span {
            margin: 10px;
            color: #000;
            display: flex;
            align-items: center;
            justify-content: flex-start;
            flex-wrap: nowrap;
        }
        
        .registerForm span div {
            font-size: 12px;
            width: 50px;
            padding: 0 5px;
            text-align: right;
        }
        
        .registerForm div {
            width: 100%;
            font-size: 12px;
            padding-left: 50px;
            display: flex;
        }
        
        .registerForm .registerBtn {
            background-color: darkgoldenrod;
            border: none;
            border-radius: 5px;
            color: #fff;
            padding: 5px 18px;
            font-size: 12px;
            position: absolute;
            right: 10px;
            bottom: 5px;
        }
    </style>
</head>

<body>

    <%
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

    %>
        <div class="container">
            <div class="d1">用户注册</div>
            <div class="d2">欢迎注册本网站会员</div>
            <form class="registerForm" action="checkLogin.jsp">
                <div class="title">创建新账户</div>
                <span>  用户名:<%=userName%>  </span>
                <span>    密码:<%=password%></span>
                <span>电子邮件:<%=email%></span>
                <span>    电话:<%=phone%></span>
                <span>    地址:<%=address%></span>
                <span>
                    <a style="color: goldenrod" href="./login.jsp">返回登录</a>
                </span>
            </form>
        </div>
</body>

</html>