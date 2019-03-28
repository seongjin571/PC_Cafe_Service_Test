package AdminChat;
import java.net.*;
import java.io.*;

public class UserChat {
	public static void main(String args[]) {
		try {
			String serverIp = "192.168.0.9";
            
			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 3000); 

			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {  
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} // main
} // class
