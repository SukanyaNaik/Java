package simpleGUI;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI implements ActionListener{
	JButton button;
	
	public static void main(String[] args) {
		SimpleGUI gui = new SimpleGUI();
		gui.go();
	}

	public void go()
	{
		JFrame frame = new JFrame();
		button = new JButton("Test Button");
		
		button.addActionListener(this);
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		button.setText("I've been clicked");
	}
}
