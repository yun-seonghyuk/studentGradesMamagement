package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.green.dao.MemberDao;
import com.green.dto.MemberDto;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		System.out.println("응답");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {
			url = "index.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "index.jsp";
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberBan = request.getParameter("memberBan");
		String authority = request.getParameter("authority");
		String memberName = request.getParameter("memberName");
		
		
		
		System.out.println(memberBan);
		System.out.println(memberId);
		MemberDao dao = MemberDao.getInstance();
		int result = dao.memberCheck(memberId,memberPwd);
		String homeRoomTeacher = dao.homeRoomTeacherSelect(memberId);
		if(result == 1) {
			
			MemberDto mto  = dao.getMemer(memberId);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", mto);
			session.setAttribute("memberId", memberId);
			session.setAttribute("memberName",mto.getMemberName());
			session.setAttribute("memberBan",mto.getMemberBan());
			session.setAttribute("authority", mto.getAuthority());
			session.setAttribute("homeRoomTeacher", homeRoomTeacher);
			
		}else if(result == 0){// 비밀번호가 틀린경우
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			url = "member/login.jsp";
		}else if(result == -1) {// 아이디가 없는 경우
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			url = "member/login.jsp";
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
