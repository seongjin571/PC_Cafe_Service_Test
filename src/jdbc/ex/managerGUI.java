package jdbc.ex;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import jdbc.dto.Food;
import jdbc.dto.Stock;


public class managerGUI extends JFrame{
	 private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	 private static String dbUser = "java";
	 private static String dbpasswd = "wkqktmxjel";

	   Connection conn = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   String[] ingredient;
	   JLabel la;
	   
	   public void showStock() {
		   
		   Object[] colNames; // 열이름 => 1차원 배열
	       Object[][] data; // 2차원 배열 데이터
	       Container contentPane;
		   
	       setTitle("재고 관리 프로그램");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       setLayout(new BorderLayout());
	       contentPane = getContentPane();
		   
		   try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock";
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
            
            la=new JLabel("재고 현황");
            
            contentPane.add(la,BorderLayout.NORTH);
            
            // 테이블 생성
            JTable table = new JTable(data, colNames);
            // 테이블을 프레임 컨텐트팬 중앙에 붙이기
            contentPane.add(new JScrollPane(table));
            // 두번째 추가한 요소부터는 setVisible해야지만 새로 추가한 요소가 출력됨
            
            table.setBounds(50, 50, 500, 500);
            
            setSize(1000, 500);
            setVisible(true);
            
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
			   
			   
		   }
	   }
}
