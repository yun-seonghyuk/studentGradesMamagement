package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;

@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.confirmId(memberId);
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("member/idCheck.jsp").forward(request, response);
		
	}

}
