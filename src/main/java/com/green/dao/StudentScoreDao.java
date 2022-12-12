package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Fidelity;

import com.green.db.DBManager;
import com.green.dto.MemberDto;
import com.green.dto.StudentScoreDto;

public class StudentScoreDao {
	private StudentScoreDao() {}
	private static StudentScoreDao dao = new StudentScoreDao();
	
	public static StudentScoreDao getInstance() {
		return dao;
	}


	public List<StudentScoreDto> selectAllscoreList() {
		List<StudentScoreDto> scoreList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM studentScoreTbl ORDER BY memberName ASC";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				StudentScoreDto sto = new StudentScoreDto();
				
				sto.setKor(rs.getInt("kor"));
				sto.setEng(rs.getInt("eng"));
				sto.setMath(rs.getInt("math"));
				sto.setScience(rs.getInt("science"));
				sto.setSocial(rs.getInt("social"));
				scoreList.add(sto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return scoreList;
	}



	public StudentScoreDto selectScoreByName(String memberName) {
		StudentScoreDto sto = null;
		
		String sql = "SELECT * FROM studentScoreTbl WHERE memberName =? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberName);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sto = new StudentScoreDto();
				sto.setKor(rs.getInt("kor"));
				sto.setEng(rs.getInt("eng"));
				sto.setMath(rs.getInt("math"));
				sto.setScience(rs.getInt("science"));
				sto.setSocial(rs.getInt("social"));
				sto.setTotal(rs.getInt("kor"), rs.getInt("math"), rs.getInt("eng"),rs.getInt("social"), rs.getInt("science"));
				sto.setAvg(rs.getInt("total"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return sto;
	}




	public double[] subjectScoreByScore(List<StudentScoreDto> scoreList, String memberBan,int count) {
		double[] subjectScoreByScore = new double[5];
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * "
				+ " from memberTbl NATURAL JOIN studentScoreTbl "
				+ " where memberban =?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberBan);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				subjectScoreByScore[0]+= rs.getInt("kor");
				subjectScoreByScore[1]+= rs.getInt("eng");
				subjectScoreByScore[2]+= rs.getInt("math");
				subjectScoreByScore[3]+= rs.getInt("science");
				subjectScoreByScore[4]+= rs.getInt("social");
			}
			
			for(int i = 0; i < subjectScoreByScore.length; i++) {
				subjectScoreByScore[i]/= count;
				subjectScoreByScore[i] = Math.round(subjectScoreByScore[i] * 100)/100.0;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return subjectScoreByScore;
	}
	
	public int countAll(String sql,String memberBan) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberBan);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return count ;
	}

	public int memberBanCount(String memberBan,String authority) {
		// 점수 미등록된 학생포함 개수
		
		int count = 0;
		String sql = " select count(*) from memberTbl  left outer JOIN studentScoreTbl\r\n"
				+ "on memberTbl.memberName = studentScoreTbl.memberName\r\n"
				+ "where memberBan = ? and authority not in ?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberBan);
			psmt.setString(2, authority);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return count;
	}
	
	public int memberBanCount2(String memberBan) {
		// 점수가 미등록된 학생제외시킨 개수
		
		String sql = "select count(*)\r\n"
				+ " from memberTbl NATURAL JOIN studentScoreTbl\r\n"
				+ " where memberBan = ? ";
		
		int count = countAll(sql, memberBan);
		return count;
	}
	
	public List<MemberDto> studentList(String memberBan, String authority) {
		List<MemberDto> list  = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "select memberId, memberName \r\n"
				+ "from memberTbl\r\n"
				+ "where memberBan = ? and  authority not in ?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberBan);
			psmt.setString(2, authority);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDto mto2 = new MemberDto();
				mto2.setMemberId(rs.getString("memberId"));
				mto2.setMemberName(rs.getString("memberName"));
				System.out.println(mto2.getMemberId());
				list.add(mto2);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return list;
	}


	public int scoreRegistration(StudentScoreDto mto, String memberName) {
		int result = -1;
		
		
		String sql = " INSERT INTO studentScoreTbl "
					+" (memberName,kor,eng,math,science,social)"
					+" VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberName);
			psmt.setInt(2, mto.getKor());
			psmt.setInt(3, mto.getEng());
			psmt.setInt(4, mto.getMath());
			psmt.setInt(5, mto.getScience());
			psmt.setInt(6, mto.getSocial());
			
			result = psmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
		return result;
	}


	public void updateScore(StudentScoreDto sto, String updateMember) {
		String sql = "update studentScoreTbl set kor=?, eng=?, math=?, science=?, social=?\r\n"
				+ " where memberName =?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try{
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sto.getKor());
			psmt.setInt(2, sto.getEng());
			psmt.setInt(3, sto.getMath());
			psmt.setInt(4, sto.getScience());
			psmt.setInt(5, sto.getSocial());
			psmt.setString(6, updateMember);
			
			psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}


	



	
	
}
