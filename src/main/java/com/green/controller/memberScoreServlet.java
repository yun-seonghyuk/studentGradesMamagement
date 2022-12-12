package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.green.dao.MemberDao;
import com.green.dao.StudentScoreDao;
import com.green.dto.MemberDto;
import com.green.dto.StudentScoreDto;


@WebServlet("/grade")
public class memberScoreServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentScoreDao dao = StudentScoreDao.getInstance();
		
		String url = null;
		HttpSession session = request.getSession();
		String memberName = (String)session.getAttribute("memberName");
		String authority = (String)session.getAttribute("authority");
		String memberName2 = request.getParameter("memberName");
		
		if(authority.equals("학생")) {
			url = "student/memberScore.jsp";
			StudentScoreDto sto = dao.selectScoreByName(memberName);
			request.setAttribute("StudentScore", sto);
		}else {
			url = "teacher/memberScore.jsp";
			StudentScoreDto sto = dao.selectScoreByName(memberName2);
			request.setAttribute("StudentScore", sto);
		}
		
		request.setAttribute("memberName2", memberName2);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
