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
import com.green.dto.StudentScoreDto;

@WebServlet("/banScore")
public class BanAvgScoreServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentScoreDao dao = StudentScoreDao.getInstance();
		HttpSession session = request.getSession();
		
		String url = null;
		String memberBan = (String)session.getAttribute("memberBan");
		String authority = (String)session.getAttribute("authority");
		
		if(authority.equals("학생")) {
			url = "student/banScore.jsp";
		}else if(authority.equals("선생")){
			url = "teacher/banScore.jsp";
		}else {
			url = "index.jsp";
		}
		
		System.out.println(memberBan);
		List<StudentScoreDto> scoreList = dao.selectAllscoreList();
		int count2 = dao.memberBanCount2(memberBan);
		double []subjectScore = dao.subjectScoreByScore(scoreList,memberBan,count2);
		
		request.setAttribute("subjectScore", subjectScore);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
