import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args) {
		SimpleChatClientA clientA = new SimpleChatClientA();
		clientA.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("Chat Client");
		JPanel panel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send");
		
		setUpNetworking();
		sendButton.addActionListener(new SendButtonListener());
		panel.add(outgoing);
		panel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	private void setUpNetworking() {
		try {
			Socket socket = new Socket("127.0.0.1",4242);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("Connection established");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public class SendButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
		
	}
}
