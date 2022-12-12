package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDao;
import com.green.dto.MemberDto;

@WebServlet("/unregistered")
public class ScoreUnregisteredServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao dao = MemberDao.getInstance();
		String url = "teacher/scoreUNregistered.jsp";
		
		HttpSession session = request.getSession();
		String authority = (String)session.getAttribute("authority");
		String memberBan = (String)session.getAttribute("memberBan");
		System.out.println(authority);
		List<MemberDto> nmL = dao.notRegitered(authority, memberBan); 
		
		request.setAttribute("nmL", nmL);
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

}
