package com.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.dto.MemberDto;
import com.green.dto.StudentScoreDto;


public class MemberDao {
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	

	public int memberCheck(String memberId, String memberPwd) {
		int result = -1;
		String sql = "SELECT memberPwd FROM memberTbl WHERE memberId =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("memberPwd") != null &&
					rs.getString("memberPwd").equals(memberPwd)){
					result = 1; // 로그인성공
				}else{
					result = 0; // 비밀번호가 null 이거나, 비밀번호가 일치하지 않는경우
				}
			}else {
				result = -1; // 아이디를 찾을수 없는 경우
			}
		}catch (Exception e) {
			
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return result;
	}



	public MemberDto getMemer(String memberId) {
		MemberDto mto = null;
		
		String sql = "SELECT * FROM memberTbl WHERE memberId =?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mto = new MemberDto();
				mto.setMemberId(rs.getString("memberId"));
				mto.setMemberPwd(rs.getString("memberPwd"));
				mto.setMemberName(rs.getString("memberName"));
				mto.setMemberBan(rs.getString("memberBan"));
				mto.setAuthority(rs.getString("authority"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return mto;
	}


	public int confirmId(String memberId) {
		int result = -1;
		
		String sql = "SELECT memberId FROM memberTbl WHERE memberId=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // 아이디가 존재 => 아이디 중복
			}else {
				result = -1; // 아이디가 부존재 => 아이디 사용가능
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return result;
	}


	public String homeRoomTeacherSelect(String memberId) {
		
		String homeRoomTeacher = null;
		MemberDto mto = dao.getMemer(memberId);
		
		String sql = "SELECT * from memberTbl " + 
				" where memberBan =? and  not authority IN ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mto.getMemberBan());
			psmt.setString(2, mto.getAuthority());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				homeRoomTeacher = rs.getString("memberName");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return homeRoomTeacher;
	}


	public int insertMember(MemberDto joinMember) {
		int result =-1;
		
		String sql = null;
		
		if(joinMember.getAuthority().equals("학생")) {
			sql = "INSERT INTO memberTbl VALUES(student_seq.NEXTVAL,?,?,?,?,?)";
		}else {
			sql = "INSERT INTO memberTbl VALUES(teacher_seq.NEXTVAL,?,?,?,?,?)";
		}
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, joinMember.getMemberId());
			psmt.setString(2, joinMember.getMemberName());
			psmt.setString(3, joinMember.getMemberPwd());
			psmt.setString(4, joinMember.getMemberBan());
			psmt.setString(5, joinMember.getAuthority());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, null);
		}
		return result;
	}


	public List<MemberDto> notRegitered(String authority, String memberBan) {
		List<MemberDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT memberTbl.memberName FROM "
				+ " memberTbl left outer join studentScoreTbl "
				+ " ON memberTbl.memberName = studentScoreTbl.memberName "
				+ " where authority not in ? and memberBan =?  and social is null";
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, authority);
			psmt.setString(2, memberBan);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDto mto = new MemberDto();
				mto.setMemberName(rs.getString("memberName"));
				list.add(mto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return list;
	}


	public void deleteStudent(String deletMameber) {
		String sql = "DELETE FROM memberTbl WHERE memberName=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, deletMameber);
			
			psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

}
