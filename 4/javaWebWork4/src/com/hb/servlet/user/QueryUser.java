package com.hb.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.bean.User;
import com.hb.dao.UserDao;




@WebServlet("/queryUserServlet")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao;
    public QueryUser() {
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
		{	if(request.getParameter("id")!=null)
			{
				int id = Integer.parseInt(request.getParameter("id"));
				User user = (User) request.getSession().getAttribute("user");//获取user信息
				if(id!=user.getId())
				{
					response.getWriter().print("非法查询");
					return;
				}
				try {
					List<Map<String, Object>> parmList = new ArrayList<Map<String,Object>>();
					Map<String, Object> parm= new HashMap<String,Object>();
					parm.put("col", "name");
					parm.put("rel", "=");
					parm.put("value",user.getName());
					parmList.add(parm);
					List<User> userT = userDao.queryByParams(parmList);
					User userC = userT.get(0);
					if(userC.getId()!=0)
					{
						request.getSession(true).setAttribute("user", userC);
						response.getWriter().print("查询成功");
					}
				} catch (Exception e) {
					
					response.getWriter().print("系统错误");
					e.printStackTrace();
				
				}
			}
			else
			{
				
				response.getWriter().print("参数错误");
			}
		}
		else
		{
			request.setAttribute("message", "请登录后操作");
			request.getRequestDispatcher("login.jsp").forward(request, response);//用户未登录跳转
		}
	}

}