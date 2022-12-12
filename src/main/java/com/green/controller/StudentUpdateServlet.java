package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDao;
import com.green.dao.StudentScoreDao;
import com.green.dto.MemberDto;
import com.green.dto.StudentScoreDto;

@WebServlet("/studentUpdate")
public class StudentUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateMember = request.getParameter("memberName");
		StudentScoreDao dao = StudentScoreDao.getInstance();
		System.out.println(updateMember);
		StudentScoreDto sto = dao.selectScoreByName(updateMember); 
		request.setAttribute("sto", sto);
		HttpSession session = request.getSession();
		session.setAttribute("updateMember", updateMember);
		request.getRequestDispatcher("teacher/studentUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String updateMember = (String)session.getAttribute("updateMember");
		
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int science = Integer.parseInt(request.getParameter("science"));
		int social = Integer.parseInt(request.getParameter("social"));
		
		System.out.println(updateMember);
		StudentScoreDto sto = new StudentScoreDto();
		sto.setKor(kor);
		sto.setEng(eng);
		sto.setMath(math);
		sto.setScience(science);
		sto.setSocial(social);
		
		StudentScoreDao dao = StudentScoreDao.getInstance();
		dao.updateScore(sto,updateMember);
		
		response.sendRedirect("studentList");
	}

}
