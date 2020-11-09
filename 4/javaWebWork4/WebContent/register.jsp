<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
    <div class="container">
        <div class="d1">用户注册</div>
        <div class="d2">欢迎注册本网站会员</div>
        <form class="registerForm" action="insertUserServlet" method = "post">
            <div class="title">创建新账户</div>
            <span>
              <div>用户名</div>
              <input type="text" name="userName"/>
          </span>
            <span>
              <div>密码</div>
              <input type="password" name="password">
          </span>
            <span>
                <div>密码确认</div>
                <input type="password" name="repassword">
            </span>
            <span>
                <div>电子邮件</div>
                <input type="text" name="email">
            </span>
            <span>
                <div>电话</div>
                <input type="number" name="phone">
            </span>
            <span>
                <div>地址</div>
                <input type="text" name="address">
            </span>
            <div>
                <input type="checkbox" name="agree">我同意 <a style="color: goldenrod" href="http://www.baidu.com">相关协议和政策</a>
            </div>
            <button type="submit" class="registerBtn">注册</button>
        </form>
         <span style="float:right"><a href="login.jsp" style="color: goldenrod">已有账号登录</a></span>
    </div>
</body>

</html>