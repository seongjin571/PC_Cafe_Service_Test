package javaProject;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jdbc.dto.user;
import jdbc.dao.*;
import jdbc.dto.*;

public class Join extends JFrame   {
	JLabel lb1, la1, la2, la3, la4, status;
	JTextField id, pw, pw2, email;
	JPanel idPanel, paPanel, pa2Panel, emPanel;
	JButton b1, b2;
	ActionEvent e;
	int flag=0;
	user_inf u_inf = new user_inf();

	Join(String str){
		super(str);
		setLayout(null); //레이아웃 내가 원하는 위치로

		J_idpw();
		J_button();
	}
	
	void J_idpw() {
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		pa2Panel = new JPanel();
		emPanel = new JPanel();

		la1 = new JLabel("ID");
		la1.setFont(new Font("",Font.BOLD, 20));
		la2 = new JLabel("PW");
		la2.setFont(new Font("",Font.BOLD, 20));
		la3 = new JLabel("PW 확인");
		la3.setFont(new Font("",Font.BOLD,20));
		la4 = new JLabel("E-mail");
		la4.setFont(new Font("",Font.BOLD, 20));//ID, PW 등 글자 설정
		
		
		id = new JTextField(13);
		id.setFont(new Font("",Font.BOLD, 20));
		pw = new JPasswordField(13);//입력시 ●로 입력됨
		pw.setFont(new Font("",Font.BOLD, 20));
		pw2 = new JPasswordField(13);//입력시 ●로 입력됨
		pw2.setFont(new Font("",Font.BOLD, 20));
		email = new JTextField(13);
		email.setFont(new Font("",Font.BOLD, 20));//id, pw 등 입력 창 글자 설정
		
		
		idPanel.add(la1);
		idPanel.add(id);
		idPanel.setBounds(96, 140, 300, 60);
		add(idPanel);// ID글자와 박스 삽입

		paPanel.add(la2);
		paPanel.add(pw);
		paPanel.setBounds(91, 220, 300, 60);
		add(paPanel);// PW글자와 박스 삽입

		pa2Panel.add(la3);
		pa2Panel.add(pw2);
		pa2Panel.setBounds(42, 300, 350, 60);
		add(pa2Panel);// pw2글자와 박스 삽입
		
		emPanel.add(la4);
		emPanel.add(email);
		emPanel.setBounds(80, 380, 300, 60);
		add(emPanel);// email글자와 박스 삽입
	}
	
	void J_button() {
		
		b1 = new JButton("중복");
		b2 = new JButton("JOIN");//중복, JOIN 버튼 생성
		
		b1.setBounds(400,143,100,33);//위치, 크기 설정
		b1.setBackground(new Color(210,50,50));//색상 빨간색
		b1.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
		b1.setForeground(new Color(255,255,255));//글씨 하얀색
		
		b2.setBounds(210,480,120,40);
		b2.setBackground(new Color(210,50,50));
		b2.setFont(new Font("",Font.PLAIN,17));
		b2.setForeground(new Color(255,255,255));
		
		add(b1);
		add(b2);//중복, JOIN 버튼 설정 후 삽입
		
		status = new JLabel();
		b2.addActionListener(new ActionListener() {//JOIN버튼 클릭시 발생하는 액션
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(id.getText().equals("")) {//id 입력 안된 경우
					status.setText("id를 입력해 주십시오.");
				}
				else if(flag==0) {//id 중복 확인 안한 경우
					status.setText("id 중복을 확인해 주십시오.");
				}
				else if(pw.getText().equals("")) {//pw 입력 안된 경우
					status.setText("pw를 입력해 주십시오.");
				}
				else if(pw2.getText().equals("")) {//pw 입력 안된 경우
					status.setText("pw를 확인해 주십시오.");
				}
				else if(email.getText().equals("")) {//이메일이 입력 안된 경우
					status.setText("이메일을 입력해 주십시오.");
				}
				
				else if(!(pw.getText().equals(pw2.getText()))) {//pw의 값과 pw2의 값이 같지 않으면
					status.setText("비밀번호가 일치하지 않습니다.");
				}
				else{//위의 모든 경우를 만족하는 경우에는 오류 메시지 출력 없음
					status.setText("");
					user u = new user(0,id.getText(), pw.getText(), email.getText(), 0);
					u_inf.addMember(u);
				}
			}
		});
		
	
		
		b1.addActionListener(new ActionListener() {//중복버튼 클릭시 발생하는 액션
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				flag=1;//중복 확인 했다는 의미
				
				int n = u_inf.compareID(id.getText());
				if(n == -1)
					status.setText("이미 존재하는 ID입니다.");
				else
					status.setText("사용 가능한 ID입니다.");
		
			}
		});
		
		status.setFont(new Font("",Font.PLAIN,15));
		status.setHorizontalAlignment(JTextField.CENTER);//가운데정렬
		status.setBounds(153,520,240,40);
		add(status);// id+pw 인 status 설정 후 삽입
		
		
	}

	
}