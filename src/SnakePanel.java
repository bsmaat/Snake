import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SnakePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int direc = 0; // for the direction of the snake
	
	int gridx = 25; int gridy = 25; // grid size
	int size = 10; // size of each snake element
	static boolean running = false;
	Snake s;
	
	public SnakePanel() {
		setPreferredSize(new Dimension(gridx*size, gridy*size));
		this.setBackground(Color.WHITE);
		initializeKeyBindings();
		s = new Snake(gridx, gridy, size);
		Timer t = new Timer(200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (running == true) {
					s.move();
					if (running) // only repaint if we are alive
						repaint();
				}
			}
		});
		t.start();
	}
	
	public static void snakeStatus(boolean x) {
		running = x;
	}
	
	public void updateMovement(int i) {
		direc = i;
		s.setDirec(i);
	}
	
	
	// 0 = right, 1 = left, 2 = down, 3 = up
	private void initializeKeyBindings() {
		Action doRight = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				updateMovement(0);
				System.out.println("nihao");
			}
		};
		Action doLeft = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				updateMovement(1);
			}
		};
		Action doDown = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				updateMovement(2);
			}
		};
		Action doUp = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				updateMovement(3);
			}
		};
		InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = this.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), "right");
		am.put("right", doRight);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0), "left");
		am.put("left", doLeft);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0), "up");
		am.put("up", doUp);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0), "down");
		am.put("down", doDown);
		//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), "pause");
		//am.put("pause", doWork);
	}
	
	
	// draw the snake
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		s.drawSnake(g);
		
	}
	
	

}
