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
import com.green.dao.StudentScoreDao;
import com.green.dto.MemberDto;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentScoreDao dao = StudentScoreDao.getInstance();
		HttpSession session = request.getSession();
		
		
		String url = "teacher/studentList.jsp";
		String memberBan = (String)session.getAttribute("memberBan");
		String authority = (String)session.getAttribute("authority");
		
		int count = dao.memberBanCount(memberBan,authority);
		System.out.println(authority);
		System.out.println(memberBan);
		System.out.println(count);
		List<MemberDto> mto2 = dao.studentList(memberBan,authority);
		
		request.setAttribute("mto2", mto2);
		request.setAttribute("count", count);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	

}
