import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimplechatServer {

	JTextField serverMessage; 
	public static void main(String[] args) {
		SimplechatServer server = new SimplechatServer();
		server.go();
	}

	public void go () {
		JFrame frame = new JFrame("chat Server");
		JPanel panel = new JPanel();
		serverMessage = new JTextField(20);
		
		panel.add(serverMessage);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(400,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		setUpNetworking();
	}
	
	private void setUpNetworking() {
		try {
			ServerSocket serverSocket = new ServerSocket(4242);
			
			while (true) {
				Socket socket = serverSocket.accept();
				InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader reader = new BufferedReader(streamReader);
				serverMessage.setText("");
				serverMessage.setText(reader.readLine());
				serverMessage.setCaretPosition(serverMessage.getText().length());
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
