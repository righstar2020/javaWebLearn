package com.hb.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.dao.UserDao;

@WebServlet("/insertUserServlet")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao;
    public InsertUser() {
        super();
        this.userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String haveLogin = (String) request.getSession(true).getAttribute("haveLogin");//用户登录情况
		
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			if(request.getParameter("userName")!=null&&request.getParameter("password")!=null)
			{
				User user = new User();
				String name = request.getParameter("userName");
				String pwd = request.getParameter("password");
				String email = request.getParameter("email")==null?"":request.getParameter("email");
				String phone = request.getParameter("phone")==null?"":request.getParameter("phone");
				String address = request.getParameter("address")==null?"":request.getParameter("address");
				
				user.setName(name);
				user.setPwd(pwd);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				
				try {
					userDao.addUser(user);
					response.getWriter().print("注册成功");
					response.getWriter().print(user.toString());
					request.getRequestDispatcher("checkRegister.jsp").forward(request, response);
				} catch (Exception e) {
					response.getWriter().print("系统错误");
					response.sendRedirect("register.jsp");
					e.printStackTrace();
				}
				
				
				
			}
	}

}
