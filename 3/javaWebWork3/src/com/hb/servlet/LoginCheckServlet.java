package com.hb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.service.UserCheck;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginCheckServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String verifyCode = request.getParameter("verifyCode");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		
		UserCheck uc = new UserCheck();
		//验证码效验
		String checkCode = (String) request.getSession(true).getAttribute("verifyCode");
		if(checkCode!=null&&checkCode.equalsIgnoreCase(verifyCode))	
			if(uc.validate(user))
			{
				request.setAttribute("user", user);
				request.setAttribute("rememberMe", rememberMe);
				RequestDispatcher dis = request.getRequestDispatcher("loginSuccess.jsp");
				
				if(rememberMe!=null&&rememberMe.equals("on"))
				{
					//记住登录状态自动登录利用cookies
					 //记住登录状态
	                Cookie cookie1 = new Cookie("userName", user.getName());
					cookie1.setMaxAge(7*24*60*60);
					response.addCookie(cookie1);
	
	                Cookie cookie2 = new Cookie("password", user.getPwd());
					cookie2.setMaxAge(7*24*60*60);
					response.addCookie(cookie2);
					request.setAttribute("message", "已记录登录状态");
					
				}
				else
					request.setAttribute("message", "登录成功");
					dis.forward(request, response);
			}
			else
			{
				request.setAttribute("message", "信息有误");
				request.getRequestDispatcher("login.jsp").forward(request, response);;
			}
		else
		{
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
				
	}

}
