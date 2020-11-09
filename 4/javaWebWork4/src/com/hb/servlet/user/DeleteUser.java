package com.hb.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.dao.UserDao;


@WebServlet("/deleteUserServlet")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDao userDao;
    public DeleteUser() { 	
        super();
        this.userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String haveLogin = (String) request.getSession(true).getAttribute("haveLogin");//用户登录情况
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(haveLogin!=null&&haveLogin.equals("yes"))
		{
			if(request.getParameter("id")!=null)
			{
				int id = Integer.parseInt(request.getParameter("id"));
				User user = (User) request.getSession().getAttribute("user");//获取user信息
				if(id!=user.getId())
				{
					response.getWriter().print("<script>"
							+ "alert('非法删除');"
							+ "window.history.back()"
							+ "</script>");
					return;
				}
				
				try {
					userDao.deleteUser(id);
					response.getWriter().print("<script>"
							+ "alert('删除成功');"
							+ "window.history.back()"
							+ "</script>");
				} catch (Exception e) {
					
					e.printStackTrace();
					response.getWriter().print("系统错误");
				}
				
			}
			else
			{
				
			
				response.getWriter().print("<script>"
						+ "alert('参数错误');"
						+ "window.history.back()"
						+ "</script>");
			}
		}
		else
		{
			request.setAttribute("message", "请登录后操作");
			request.getRequestDispatcher("login.jsp").forward(request, response);//用户未登录跳转
		}
		
	}

}