import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993778411941960466L;

	public InputPanel() {
		this.setLayout(new FlowLayout());
		
		JButton bStart = new JButton("Start");
		JButton bStop = new JButton("Stop");
		bStart.addActionListener(this);
		bStart.setActionCommand("start");
		bStop.addActionListener(this);
		bStop.setActionCommand("stop");
		this.add(bStart);
		this.add(bStop);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("start".equals(e.getActionCommand())) {
			System.out.println("Start!!");
			SnakePanel.snakeStatus(true);
		}
		if ("stop".equals(e.getActionCommand())) {
			SnakePanel.snakeStatus(false);
		}
	}
	
	
}
