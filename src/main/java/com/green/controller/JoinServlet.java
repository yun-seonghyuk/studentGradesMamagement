package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDao;
import com.green.dto.MemberDto;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/join.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberPwd = request.getParameter("memberPwd");
		String memberBan = request.getParameter("memberBan");
		String authority = request.getParameter("authority");
		
		System.out.println(authority);
		
		MemberDto joinMember = new MemberDto();
		System.out.println(memberBan);
		joinMember.setMemberId(memberId);
		joinMember.setMemberName(memberName);
		joinMember.setMemberPwd(memberPwd);
		joinMember.setMemberBan(memberBan);
		joinMember.setAuthority(authority);
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.insertMember(joinMember);
		
		if(result == 1) {
			request.setAttribute("memberId", memberId); // 가입한 id로 로그인 유도!!
			request.setAttribute("message", "회원 가입에 성공하셨습니다.");
		}else {
			request.setAttribute("message", "회원 가입에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher("member/login.jsp").forward(request, response); 
		
	}

}
