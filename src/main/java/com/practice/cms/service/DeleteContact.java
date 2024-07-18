package com.practice.cms.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.cms.config.Singleton;
@WebServlet("/delete_contact")
public class DeleteContact extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		boolean result = Singleton.getContactDao().deleteContact(id);
		if(result) {
			resp.sendRedirect("manage_contact");
		}
		else {
			
		}
	}

}
