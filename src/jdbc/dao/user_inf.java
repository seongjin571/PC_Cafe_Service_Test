package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jdbc.dto.user;


public class user_inf {
	
	private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	
	private static String dbUser = "java";
	private static String dbpwd = "wkqktmxjel";
	
	 user u = null;
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 
	public int compareID(String id) {
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select u_id from user_inf";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String u_id = rs.getString("u_id");
				if(u_id.equals(id))
					return -1;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
		 return 0;
	 }
	public void addMember(user u) {

		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "insert into user_inf value(?,?,?,0)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getU_id());
			ps.setString(2, u.getU_pw());
			ps.setString(3, u.getU_email());
			result = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public int login(String id, String pw) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select u_id, u_pw from user_inf where u_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		//	ps.setString(2, pw);
			if(rs.next()) {
				String u_id = rs.getString("u_id");
				String u_pw = rs.getString("u_pw");
				if(u_id.equals(id)) {
					if(u_pw.equals(pw))
						result = 1;// id, pw 둘다 일치
					else
						result = 2;// id만 일치
				}
				else
					result = 3;// id, pw 둘다 불일치
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
}