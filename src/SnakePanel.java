import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.List;
import java.util.Random;
;public class SnakePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int direc = 0; // for the direction of the snake
	
	int gridx = 25; int gridy = 25; // grid size
	int size = 10; // size of each snake element
	static boolean running = false;
	boolean foodOn = false; int foodx = 0; int foody=0;
	Snake s;
	
	public SnakePanel() {
		setPreferredSize(new Dimension(gridx*size, gridy*size));
		this.setBackground(Color.WHITE);
		initializeKeyBindings();
		s = new Snake(gridx, gridy, size);
		Timer t = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (running == true) {
					s.move();
					eat();
					if (foodOn == false)
						createFood();
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
	
	public void createFood() {
		Random rnd = new Random();
		foodx = rnd.nextInt(gridx);
		foody = rnd.nextInt(gridy);
		boolean unique = false;
		List<Integer> snakex = s.getAllX();
		List<Integer> snakey = s.getAllY();
		while(unique==false) {
			for (int i=0; i < snakex.size(); i++) {
				if (foodx == snakex.get(i)) {
					if (foody == snakey.get(i)) {
						//generate a new random number
						foodx = rnd.nextInt(gridx);
						foody = rnd.nextInt(gridy);
						break;
					}
				} else {
					unique = true;
					break;
				}
			}
		}
		foodOn = true;
	}
	
	public void eat() {
		if ((s.getPosX() == foodx) && (s.getPosY() == foody)) {
			s.addEl();
			foodOn = false;
		}
	}
	
	
	// draw the snake
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		s.drawSnake(g);
		g.setColor(Color.RED);
		g.fillRect(foodx*size, foody*size, size, size);
		
	}
	
	

}
