package com.practice.cms.service;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.cms.config.Singleton;
import com.practice.cms.dao.UserDao;
import com.practice.cms.entity.User;
@WebServlet("/register")
public class RegisterUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User();
		
		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		boolean result = Singleton.getUserDao().saveUser(user);
		if(result) {
			resp.sendRedirect("login.jsp");
			
		}
		else {
			req.setAttribute("fail","registration unsuccessful");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
			
		}
		
	}

}
