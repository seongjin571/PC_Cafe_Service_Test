package AdminChat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class ClientChat extends JFrame implements ActionListener,Runnable,WindowListener {
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
		setLocation(1000,180);
		f1 = new Font("돋움", Font.BOLD, 30);
		addWindowListener(this);
		setTitle("SeJong Pc Cafe");
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
			textArea.append("채팅을 시작합니다. 욕설은 삼가해주세요.\n");
		} catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
//			System.exit(1);
		} catch (IOException eg) {
			eg.printStackTrace();
			textArea.append("연결에 실패하였습니다. 관리자에게 문의하세요.");
		}
		String fromServer;
		try {
			String return_str;
			string_checker ck = new string_checker();//d
			while ((fromServer = in.readLine()) != null) {
				return_str=ck.check(fromServer);
				String s = return_str + " " + nowTime() + "\n";
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

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
