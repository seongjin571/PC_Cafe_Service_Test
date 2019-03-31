package AdminChat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ClientChat extends JFrame implements ActionListener,Runnable {
	private static final long serialVersionUID = 1L;
	JButton but_input;
	JTextArea textArea;
	JTextField textInput;
	JLabel name;
	JPanel panel, panel2;
	Font f1;
	String userName;
	static PrintWriter out = null;
	static BufferedReader in = null;

	public ClientChat(String userName) {
		this.userName = userName;
		setSize(550, 600);
		f1 = new Font("돋움", Font.BOLD, 30);
		setTitle("SeJong Pc Cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		name = new JLabel("SeJong Pc Cafe 채팅방");
		name.setFont(f1);
		panel2 = new JPanel();
		textArea = new JTextArea(25, 40);
		textInput = new JTextField(20);
		textInput.registerKeyboardAction(this, "input", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		but_input = new JButton("입력");
		but_input.setActionCommand("input");
		but_input.addActionListener(this);
		panel2.add(name);
		panel.add(textArea);
		panel.add(textInput);
		panel.add(but_input);
		add(panel2, BorderLayout.NORTH);
		add(panel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "input") {
			String s = userName+": " + textInput.getText();
			textArea.append(s + " " + nowTime() + "\n");
			out.println(s);
			textInput.setText("");
		}
	}


	public String nowTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		LocalDateTime time = LocalDateTime.now();
		String nowTime = " [" + time.format(formatter) + "]";
		return nowTime;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("localhost", 3000);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
			System.exit(1);
		} catch (IOException eg) {
			System.err.println("입출력 오류11");
			System.exit(1);
		}
		String fromServer;
		try {
			while ((fromServer = in.readLine()) != null) {
				String s = fromServer + " " + nowTime() + "\n";
				textArea.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
