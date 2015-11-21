import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeFrame  {

	/**
	 * @param args
	 * 
	 */
	
	public SnakeFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake");
		//snake.setSize(300,500);
		frame.setVisible(true);
		Container contentPane =  frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		SnakePanel p = new SnakePanel();
		p.setPreferredSize(new Dimension(500,500));
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(p, BorderLayout.CENTER);
		
		InputPanel inputPan = new InputPanel();
		contentPane.add(inputPan, BorderLayout.PAGE_END);
		frame.pack();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		SnakeFrame s = new SnakeFrame();
	}
	

}
