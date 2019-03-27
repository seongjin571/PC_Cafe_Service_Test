package jdbc.dao;

<<<<<<< HEAD
import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import jdbc.dto.Food;
import jdbc.dto.Stock;

public class PCDao extends JFrame{
=======
import java.sql.*;
import java.util.*;

import jdbc.dto.Food;
import jdbc.dto.Stock;

public class PCDao {
>>>>>>> b53de909580370ac63681362dce5f27b6734dcae
	private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	 private static String dbUser = "root";
	 private static String dbpasswd = "16010948";

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
			String sql= "select id,name,price,ingredients from food where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, menu);
			rs=ps.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String ingredients=rs.getString("ingredients");
				
				ingredient=ingredients.split(",");
				
				food=new Food(id,name,price,ingredients);
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
	   public int useStock(String ingredient) {
<<<<<<< HEAD
		   
		   int count=0;
		   int result=0;
		   
		   Object[] colNames; // 열이름 => 1차원 배열
	       Object[][] data; // 2차원 배열 데이터
	       Container contentPane;
		   
	       setTitle("고객 관리 프로그램");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       setLayout(new BorderLayout());
	       contentPane = getContentPane();
		   
=======
		   int count=0;
		   int result=0;
>>>>>>> b53de909580370ac63681362dce5f27b6734dcae
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			rs=ps.executeQuery();
			while (rs.next()) {count=rs.getInt("count");}
			//재료의 재고 수를 파악
			
			sql= "update stock set count="+ (count-1) + " where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			result=ps.executeUpdate();
<<<<<<< HEAD
			
			sql= "select name,count from stock";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
          
            // 행 개수 가져오기 위해 커서를 행 마지막으로 옮기기
            rs.last();
            int rowCount = rs.getRow();
            System.out.println("행의 개수: " + rowCount);
            
            rs.first();
            
            // 열 이름을 저장할 배열객체를 열의 크기와 동일하게 생성
            colNames = new Object[rowCount];
            for(int i=0; i<rowCount; i++) {
                colNames[i] = rs.getObject(1);
                rs.next();
            }
            
            // 데이터 => 2차원 배열 저장
            rs.first();
            
            data = new Object[1][rowCount];
            for(int r=0; r<rowCount;r++) {
               data[0][r] = rs.getObject(2); // 열 인덱스
               rs.next();
            }            
            
            // 테이블 생성
            JTable table = new JTable(data, colNames);
            // 테이블을 프레임 컨텐트팬 중앙에 붙이기
            contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
            // 두번째 추가한 요소부터는 setVisible해야지만 새로 추가한 요소가 출력됨
            setSize(700, 300);
            setVisible(true);
            
			//재료의 재고 수를 한 개 줄임
=======
			//재료의 재고 수를 한 개 줄임
			
>>>>>>> b53de909580370ac63681362dce5f27b6734dcae
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
}
