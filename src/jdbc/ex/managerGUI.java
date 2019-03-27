package jdbc.ex;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import jdbc.dao.PCDao;
import jdbc.dto.Stock;

public class managerGUI extends JFrame{
	 
	   public void showStock() {
		   
		   Object[] colNames; // 열이름 => 1차원 배열
	       Object[][] data; // 2차원 배열 데이터
	       Container contentPane;
	       JLabel la;
		   
	       setTitle("재고 관리 프로그램");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       setLayout(new BorderLayout());
	       contentPane = getContentPane();
	       
	       PCDao dao=new PCDao();
		   ArrayList<Stock> list=dao.getStock();
		   
		   int rowCount = list.size();
		   System.out.println("행의 개수: " + rowCount);
            
		 
		   // 열 이름을 저장할 배열객체를 열의 크기와 동일하게 생성
		   colNames = new Object[rowCount];
		   
		   for(int i=0;i<rowCount;i++) {
			   colNames[i]=list.get(i).getName();
		   }
            
				          
			data = new Object[1][rowCount];
			for(int r=0; r<rowCount;r++) {
				data[0][r]=list.get(r).getCount();
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
	   }
}
