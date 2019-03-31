package javaProject;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import jdbc.dto.user;
import jdbc.dao.*;
import jdbc.dto.*;


public class Menu extends JFrame{
	
	JLabel status0, status1, status2, status3, ice_hot, size, shot;
	JPanel background, choice1, choice2, choice3, grid1;
	JButton b[], chat, cancle, pay;
	JRadioButton ice, hot, small, tall, large, yes, no;
	ButtonGroup group1, group2, group3;
	user_inf u_inf = new user_inf();
	int i, b_price=0, s_price=0, flag=0;
	
	Menu(String str){
		super(str);
		setLayout(null); //레이아웃 내가 원하는 위치로

		
		M_button();
		M_border(b);
		M_sorder(b);
		M_chat();
	}
	void id(String id) {
		
		//u_inf.updateprice(id);
		
	}
	void M_button() {
		
		grid1 = new JPanel();
		grid1.setLayout(new GridLayout(2,5,30,30));
		b = new JButton[10];
		
		b[0] = new JButton("아메리카노");
		b[1] = new JButton("카페라떼");
		b[2] = new JButton("아이스티");
		b[3] = new JButton("진라면");
		b[4] = new JButton("짜파게티");
		b[5] = new JButton("새우깡");
		b[6] = new JButton("홈런볼");
		b[7] = new JButton("누네띠네");
		b[8] = new JButton("건빵");
		b[9] = new JButton("핫도그");//메뉴 버튼 생성
		
		for(i=0;i<10;i++)
			grid1.add(b[i]);
		grid1.setBounds(35, 50, 800, 200);
		add(grid1);

		
	}
	void M_border(JButton b[]) {
		status0 = new JLabel();
		status1 = new JLabel();
		status2 = new JLabel();
		status3 = new JLabel();
		
		b[0].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				M_bchoice();

				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[0].getText());
				status0.setBounds(500,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		b[1].addActionListener(new ActionListener() {//카페라떼 클릭시 발생하는 액션	
			@Override
			public void actionPerformed(ActionEvent e) {
				M_bchoice();

				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[1].getText());
				status0.setBounds(500,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		b[2].addActionListener(new ActionListener() {//아이스티 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				M_bchoice();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[2].getText());
				status0.setBounds(500,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});		
	}
	void remove() {
		choice1.removeAll();
		choice1.revalidate();
		choice1.repaint();
		choice2.removeAll();
		choice2.revalidate();
		choice2.repaint();
		choice3.removeAll();
		choice3.revalidate();
		choice3.repaint();
	}
	void M_sorder(JButton b[]) {
		
		b[3].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[3].getText()+" 2000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[4].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[4].getText()+" 2000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[5].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[5].getText()+" 1000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[6].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[6].getText()+" 2000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[7].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[7].getText()+" 1000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[8].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[8].getText()+" 1000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		b[9].addActionListener(new ActionListener() {//아메리카노 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==3)
					remove();
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
				status0.setText(b[9].getText()+" 2000원");
				status0.setBounds(590,370,300,80);
				status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
				add(status0);
			}			
		});
		
		
		
		cancle = new JButton("Cancle");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
		
		cancle.addActionListener(new ActionListener() {//cancle 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
			}			
		});
	}
	void M_bchoice() {
		flag=3;
		choice1 = new JPanel();
		choice2 = new JPanel();
		choice3 = new JPanel();
		
		group1 = new ButtonGroup();
		ice = new JRadioButton("ICE");
		hot = new JRadioButton("HOT");
		group1.add(ice);
		group1.add(hot);//ice, hot 라디오버튼 생성
		
		group2 = new ButtonGroup();
		small = new JRadioButton("SMALL");
		tall = new JRadioButton("TALL");
		large = new JRadioButton("LARGE");
		group2.add(small);
		group2.add(tall);
		group2.add(large);//s,t,l 라디오버튼 생성
		
		group3 = new ButtonGroup();
		yes = new JRadioButton("YES");
		no = new JRadioButton("NO");
		group3.add(yes);
		group3.add(no);//shot 라디오버튼 생성
		
		ice_hot = new JLabel("ICE / HOT");
		size = new JLabel("SIZE");
		shot = new JLabel("SHOT");//텍스트 설정
		
		ice_hot.setFont(new Font("",Font.BOLD,15));
		size.setFont(new Font("",Font.BOLD,15));
		shot.setFont(new Font("",Font.BOLD,15));//글씨체 설정
		
		choice1.add(ice_hot);
		choice1.add(ice);
		choice1.add(hot);//panel에 더하기
		
		choice2.add(size);
		choice2.add(small);
		choice2.add(tall);
		choice2.add(large);//panel에 더하기
		
		choice3.add(shot);
		choice3.add(yes);
		choice3.add(no);//panel에 더하기
		
		choice1.setBounds(100,330,200,30);
		choice2.setBounds(500,330,250,30);
		choice3.setBounds(110,380,200,30);//panel 위치,크기 설정
		
		add(choice1);
		add(choice2);
		add(choice3);//삽입
		
		
		hot.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ HOT");
				
			}
		});
		ice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ ICE");
				
			}
		});	
		status1.setBounds(500,370,300,80);
		status1.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
		add(status1);
	
	
		small.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ SMALL");
				b_price=1000;
			}
		});
		
		tall.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ TALL");
				b_price=1500;
			}
		});
		
		large.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ LARGE");
				b_price=2000;
			}
		});
		status2.setBounds(500,370,300,80);
		status2.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
		add(status2);
		
		yes.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status3.setText(status2.getText());
				status3.setText(status3.getText()+"/ YES");
				status3.setText(status3.getText()+"/ "+b_price+"원");
			}
		});

		no.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status3.setText(status2.getText());
				status3.setText(status3.getText()+"/ NO");
				status3.setText(status3.getText()+"/ "+b_price+"원");
			}
		});
		status3.setBounds(500,370,300,80);
		status3.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
		add(status3);
		
		
		cancle = new JButton("Cancle");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
		
		cancle.addActionListener(new ActionListener() {//cancle 클릭시 발생하는 액션정의	
			@Override
			public void actionPerformed(ActionEvent e) {
				status0.setText("");
				status1.setText("");
				status2.setText("");
				status3.setText("");
			}			
		});
		
	}
	
	void M_chat() {
		chat = new JButton("chatting");
		
		chat.setBounds(110,453,200,50);//위치, 크기 설정
		chat.setBackground(new Color(210,50,50));//색상 빨간색
		chat.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
		chat.setForeground(new Color(255,255,255));//글씨 하얀색
		chat.setBorderPainted(false);
		add(chat);
	}
}