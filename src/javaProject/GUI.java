package javaProject;

import java.util.*;
import AdminChat.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.border.*;

import jdbc.dto.user;
import jdbc.dao.*;
import jdbc.dto.*;



public class GUI extends JFrame {
	JLabel lb1, la1, la2, la3, la4, status;
	JTextField id, pw;
	JPanel idPanel, paPanel, loginPanel;
	JButton b1, b2;
	JTextArea content;
	KeyListener keyListener;
	user_inf u_inf = new user_inf();
	Image img = null;
	
	public GUI() {
		super("Login"); //창 이름 Login
		setLayout(null); //레이아웃 내가 원하는 위치로

		picture();
		
		idpw();
		
		Button();
		
		setSize(650,900);//전체 창 크기 설정
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x눌렀을 때 종료
		setResizable(false);//창 크기 고정
	}
	
	void picture() {
		
		try {
			File sourceimage = new File("src\\images\\sejong.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//그림파일 가져오기
			
		la4 = new JLabel(new ImageIcon(img));
		la4.setBounds(35, 10, 550, 550);
		add(la4);// 그림 삽입
		
	}
	void idpw(){
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		la3 = new JLabel("  ID ");
		la3.setFont(new Font("",Font.BOLD, 26));
		la2 = new JLabel("PW ");
		la2.setFont(new Font("",Font.BOLD, 26));//ID, PW 글자 설정

		id = new JTextField(13);
		id.setFont(new Font("",Font.BOLD, 20));
		pw = new JPasswordField(13);//입력시 ●로 입력됨
		pw.setFont(new Font("",Font.BOLD, 20));//id, pw 입력 창 글자 설정
		
		idPanel.add(la3);
		idPanel.add(id);
		idPanel.setBounds(80, 620, 300, 80);
		add(idPanel);// ID글자와 박스 삽입

		paPanel.add(la2);
		paPanel.add(pw);
		paPanel.setBounds(80, 690, 300, 60);
		add(paPanel);// PW글자와 박스 삽입

		
	}
	void Button() {
		
		b1 = new JButton("LOGIN");
		b2 = new JButton("JOIN");//LOGIN, JOIN 버튼 생성
		
		b1.setBounds(430,615,100,125);
		b2.setBounds(250,770,120,40);
		add(b1);
		add(b2);//LOGIN, JOIN 버튼 설정 후 삽입
		
		status = new JLabel();// id+pw 보여줄 label;
		
		b1.addActionListener(new ActionListener() {//login버튼 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj1 = e.getSource();
				if((JButton) obj1 == b1) {// login버튼이 눌리면
					int n =u_inf.login(id.getText(),pw.getText());
					if(n == 2)
						status.setText("pw를 확인해주십시오");
					else if(n == 3)
						status.setText("id를 확인해주십시오");
					else if(n == 1) {
						dispose();//login 창 삭제
						
						Menu j3 = new Menu("Menu");// 새 Menu 창 생성
						j3.id(id.getText());
						j3.setVisible(true);
						j3.setSize(882, 600);//크기 설정
						j3.setLocation(500, 100);//생성될 위치 설정
						j3.addWindowListener(new WindowAdapter() {//x누르면 새창만 종료되게
							public void windowClosing(WindowEvent e) {
								j3.setVisible(false);
								j3.dispose();//Menu 창 종료
							}
						});
					}
				}
			}
		});	
		
		status.setBounds(240, 820, 150, 40);
		status.setHorizontalAlignment(JTextField.CENTER);//가운데정렬
		add(status);// id+pw 인 status 설정 후 삽입
		
		b2.addActionListener(new ActionListener() {//join버튼 클릭시 발생하는 액션
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj2 = e.getSource();
				
				if((JButton) obj2 == b2) {// join버튼이 눌리면
					Join j2 = new Join("Join");// 새 join 창 생성
					j2.setVisible(true);
					j2.setSize(550, 620);//크기 설정
					j2.setLocation(500, 100);//생성될 위치 설정
					j2.addWindowListener(new WindowAdapter() {//x누르면 새창만 종료되게
						public void windowClosing(WindowEvent e) {
							j2.setVisible(false);
							j2.dispose();//Join 창 종료
						}
					});
				}
			}
		});
		
	}
	
	public static void main(String[] args)  {
		GUI j1 = new GUI();
		ClientChat clientChat = new ClientChat();
//		clientChat.client();
		
		
	}

	
}