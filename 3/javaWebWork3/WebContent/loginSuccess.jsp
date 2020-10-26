<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
<%
	String message =(String) request.getAttribute("message");
%>


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
            margin: 15px 28px;
        }
        
        .container .d2 {
            font-size: 13px;
            width: 100%;
            margin: 15px 28px;
        }
        
        .container .loginForm {
            width: 80%;
            height: auto;
            border: 1px dotted #0e0e0e;
            padding: 0 20px;
            margin: 15px auto;
            padding: 40px 5px;
            padding-top: 5px;
            position: relative;
        }
        
        .loginForm .title {
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
        
        .loginForm span {
            margin: 10px;
            color: #000;
            display: flex;
            align-items: center;
            justify-content: flex-start;
            flex-wrap: nowrap;
        }
        
        .loginForm span div {
            font-size: 12px;
            width: 50px;
            padding: 0 5px;
            text-align: right;
        }
        
        .loginForm div {
            width: 100%;
            font-size: 12px;
            padding-left: 50px;
            display: flex;
        }
        
        .loginForm .loginBtn {
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
<jsp:useBean id="user" type="com.hb.bean.User" scope="request"/>
<body>
        <div class="container">
            <div class="d1">用户登录</div>
            <div class="d2">欢迎登录</div>
            <form class="loginForm" action="checkLoginServlet">
                <div class="title">登录</div>
                <span>用户名: <jsp:getProperty property = "name" name="user"/></span>
                <span>密码:<jsp:getProperty property = "pwd" name="user"/></span>
                <span>状态:<%=message%></span>
                <span>
                <a style="color: goldenrod" href="./login.jsp">返回登录</a>
                </span>
            </form>
        </div>
</body>

</html>



