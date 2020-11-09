package com.hb.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.hb.bean.User;

@WebServlet("/uploadImageServlet")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadImageServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String haveLogin = (String) request.getSession(true).getAttribute("haveLogin");//用户登录情况
		if(haveLogin!=null&&haveLogin.equals("yes"))
		{
			Part part = request.getPart("avator");
			User user = new User() ;
			
			if(request.getSession().getAttribute("user")==null)
			{			 
				request.setAttribute("message", "请登录后操作");
				request.getRequestDispatcher("login.jsp").forward(request, response);//用户未登录跳转
				return;
			}
			user = (User) request.getSession().getAttribute("user");
			int id = user.getId();
			if(part.getSize()>0)
			{
				System.out.println(part.getSubmittedFileName());
				File uploadFileDir = new File(getServletContext().getRealPath("images"));
				if(!uploadFileDir.exists())
				{
					uploadFileDir.mkdir();
				}
				String fileName = "avator"+Integer.toString(id)+".jpg";
				part.write(uploadFileDir+File.separator+fileName);
				response.getWriter().print("<img width='30px' heigth='30px' src='images/"+fileName+"'></img>");
				response.getWriter().print("</br>头像上传成功");
				response.getWriter().print("<script>"
						+ "alert('头像上传成功');"
						+ "window.history.back()"
						+ "</script>");
				
			}
			else
			{	
				response.getWriter().print("文件大小错误");
			}
		}
		else
		{
			request.setAttribute("message", "请登录后操作");
			request.getRequestDispatcher("login.jsp").forward(request, response);//用户未登录跳转
		}
		
	}
	
}
