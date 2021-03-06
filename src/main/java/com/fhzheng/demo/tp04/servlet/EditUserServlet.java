package com.fhzheng.demo.tp04.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhzheng.demo.tp04.service.UserService;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String status = request.getParameter("status");
		String ageStr = request.getParameter("age");
		
		int id=0,age=0;
		//分开进行try catch转换，以方便定位出错信息
		try{
			id = Integer.parseInt(idStr);
		}catch(Exception e){}
		try{
			age = Integer.parseInt(ageStr);
		}catch(Exception e){}
		//调用完成业务
		UserService userService = new UserService();
		String msg = "修改成功";
		try{
			userService.editUser(age, status, id);
		}catch(Exception e){
			e.printStackTrace();
			msg = "修改失败:"+e.getMessage();
		}
		//输出
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}

}

