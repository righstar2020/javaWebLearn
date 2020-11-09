<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="com.hb.bean.*"%>
<%@ page import="com.hb.dao.*"%>
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
            width: 500px;
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
            display: flex;
          
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
        .registerForm .avatorForm
        {
                height:100%;
                padding: 0 10px;
                width: 100px;
        }
        .avatorForm .avatorBox
        {
            width:100%;
            height:auto;
            padding 20px 5px;
            padding-left: 0px;
            font-size: 12px;
            display: block;
        }
          .avatorForm .avatorBox div
        {
            width:100%;
            padding-left: 0px;
            font-size: 12px;
            width: 100%;
            font-size: 12px;
            display: block;

        }
        
        .avatorForm .avatorBox .avator
        {
            width: 50px;
            border-radius: 100%;
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 50px;
            margin: 10px 0;
        }
        .avatorBox .avator input
        {
                width: 100px;
        }
         .avatorBox .avator img
         {
             width:50px;
             height:50px;
         }
    </style>
</head>

<body>

         <%
            
            String isLogin = (String)session.getAttribute("haveLogin");
            User user = new User();
            if(isLogin==null)
            {
                %>
                <script>
                alert("请登录后操作");
                window.open('login.jsp','_self');
                </script>
                <%
            }
            else{
            	if(session.getAttribute("user")!=null);
            		user = (User)session.getAttribute("user");
            	
            }
           
            
            int id = user.getId();
            String userName = user.getName();
            String email = user.getEmail();
            String phone =user.getPhone();
            String address = user.getAddress();

            
        %>
        <div class="container">
            <div class="d1">用户信息</div>
            <div class="d2">欢迎会员访问</div>
            <div  class="registerForm" >
                <form class="avatorForm" action="uploadImageServlet" method ="post" id="avatorForm" enctype="multipart/form-data" >
                    <div class="avatorBox">
                        <div>头像</div>
                        <div class="avator" >
                            <img src="images/avator<%=id%>.jpg">
                        </div>
                        <input type="file" name="avator" style="overflow: hidden;width: 100px;"/>
                    </div>
                    <input type="submit" value="上传" onclick="submitForm1();"/>
                    <a style="color: goldenrod;position: absolute;bottom: 30px;left: 10px;" href="deleteUserServlet?id=<%=id%>">账号注销</a>
                    <a style="color: goldenrod;position: absolute;bottom: 5px;left: 10px;" href="./login.jsp">返回登录</a>
                </form>

                <form id="info" action="updateUserServlet" method = "post">
                    <div class="title">账户信息</div>    
                    <span>
                        <div>用户ID</div>
                        <input type="text" name="id" value="<%=id%>"disabled="disabled"  />
                    </span>
                    <span>
                        <div>用户名</div>
                        <input type="text" name="userName" value="<%=userName%>" disabled="disabled"  />
                    </span>
                    <span>
                        <div>电子邮件</div>
                        <input type="text" name="email" value="<%=email%>" > 
                    </span>
                    <span>
                        <div>电话</div>
                        <input type="number" name="phone" value="<%=phone%>" >
                    </span>
                    <span>
                        <div>地址</div>
                        <input type="text" name="address" value="<%=address%>" >
                    </span>
                    <span>
                        <button type="submit" class="registerBtn">修改</button>
                    </span>
                </form>
            </div>
        </div>
</body>

</html>