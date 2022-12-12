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

@WebServlet("/scoreInput")
public class ScoreInput extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "teacher/scoreRegistration.jsp";
		HttpSession session = request.getSession();
		String  scoreInputMember = request.getParameter("memberName");
		
		session.setAttribute("scoreInputMember", scoreInputMember);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String memberName = (String)session.getAttribute("scoreInputMember");
		int kor = Integer.parseInt(request.getParameter("kor")); 
		int eng = Integer.parseInt(request.getParameter("eng")); 
		int math = Integer.parseInt(request.getParameter("math")); 
		int science = Integer.parseInt(request.getParameter("science")); 
		int social =Integer.parseInt(request.getParameter("social")); 
		
		StudentScoreDto mto = new StudentScoreDto();
		mto.setKor(kor);
		mto.setEng(eng);
		mto.setMath(math);
		mto.setScience(science);
		mto.setSocial(social);
		
		StudentScoreDao dao = StudentScoreDao.getInstance();
		
		
		int result = dao.scoreRegistration(mto,memberName);
		
		if(result == 1) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			
		}
	}

}
