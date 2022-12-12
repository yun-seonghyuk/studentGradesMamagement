package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;

@WebServlet("/studentDelete")
public class StudentDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deletMameber = request.getParameter("memberName");
		MemberDao dao = MemberDao.getInstance();
		dao.deleteStudent(deletMameber);
		
		response.sendRedirect("studentList");
		
	}

}
