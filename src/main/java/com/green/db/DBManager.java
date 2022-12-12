package com.green.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	public static Connection getConnection() throws Exception{ // 연결 객체
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","GREEN","1234");
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt , ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt ) {
		try {
			if(stmt != null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
