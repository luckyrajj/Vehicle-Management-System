package com.practice.cms.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.cms.config.Singleton;
import com.practice.cms.entity.User;
@WebServlet("/delete_user")
public class DeleteUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		User user=(User)session.getAttribute("user");
		int id=user.getUserId();
		boolean result = Singleton.getUserDao().deleteUser(id);
		if(result) {
			session.removeAttribute("user");
			resp.sendRedirect("home.jsp");
		}else {
			req.setAttribute("error", "failed to delete");
			req.getRequestDispatcher("manageprofile.jsp").forward(req, resp);
		}
	}

}
