package jdbc.dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import jdbc.dto.Food;
import jdbc.dto.Stock;

public class PCDao{
	private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	 private static String dbUser = "java";
	 private static String dbpasswd = "wkqktmxjel";

	   Food food = null;
	   Stock stock=null;
	   Connection conn = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   String[] ingredient;
	   
	   public Food getFood(String menu) {
		   
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,price,ingredients from food where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, menu);
			rs=ps.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String ingredients=rs.getString("ingredients");
				
				ingredient=ingredients.split(",");
				
				food=new Food(name,price,ingredients);
			}
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
		   return food;
	   }
	   public int useStock(String ingredient,int num) {
		   
		   int count=0;
		   int result=0;
		   
		   
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			rs=ps.executeQuery();
			while (rs.next()) {count=rs.getInt("count");}
			//재료의 재고 수를 파악
			if(count-num<0) {
				JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
				return 0;
			}
			sql= "update stock set count="+ (count-num) + " where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			result=ps.executeUpdate();
            
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
		   return result;
	   }
	   
	   public ArrayList getStock() {
		   ArrayList<Stock> list=new ArrayList<>();
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				 int count=rs.getInt("count");
				 stock=new Stock(name,count);
				 list.add(stock);
			}

            //재료의 재고 수를 한 개 줄임
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   return list;
			   
		   }
	   }
}
