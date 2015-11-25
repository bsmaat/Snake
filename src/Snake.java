/**
 * The build blocks of the snake! Each element is a part of the body
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Snake {

	/**
	 * @param args
	 */
	List<Integer> x = new ArrayList<Integer>();
	List<Integer> y = new ArrayList<Integer>();
	int size;// = 10;
	int direc = 0;
	int inc = 5;
	int joints;
	int snakeSize = 10;
	int gridx, gridy;

	public Snake(int gridx, int gridy, int size) {
		this.size = size;
		this.gridx = gridx;
		this.gridy = gridy;

		for (int i=snakeSize; i>=0; i--) {
			x.add(i);
			y.add(1);
		}
	}
	
	public void setDirec(int direc) {
		this.direc = direc;
	}
	
	public void setPosX(int x) {
		this.x.set(0, x);
	}
	
	public void setPosY(int y) {
		this.y.set(0,y);
	}
	
	public int getPosX() {
		return this.x.get(0);
	}
	
	public int getPosY() {
		return this.y.get(0);
	}
	
	public void updatePos() {
		
	}
	
	// draw the snake!
	public void drawSnake(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x.get(0)*size, y.get(0)*size, size, size);
		g.setColor(Color.BLACK);
		for(int i=1; i<x.size(); i++) {
			g.fillRect(x.get(i)*size, y.get(i)*size, size, size);	
		}
	}
	
	// 0 = right, 1 = left, 2 = down, 3 = up
	public void move() {
		for(int i=x.size()-1; i>0; i--) {
			x.set(i, x.get(i-1));
			y.set(i, y.get(i-1));
		} 
		switch(direc) {
		case(0):
			x.set(0,x.get(0)+1);
			break;
		case(1):
			x.set(0,x.get(0)-1);
			break;
		case(2):
			y.set(0,y.get(0)+1);
			break;
		case(3):
			y.set(0,y.get(0)-1);
			break;			
		}
		
		if (isDead() == true) {
			SnakePanel.running = false;
		}

	}
	
	public boolean isDead() {
		//check to see if it hits it self
		for(int i=x.size()-1; i>0; i--) {
			if ( (x.get(0) == x.get(i)) && (y.get(0) == y.get(i)) )
				//System.out.println("Died");
				return true;
		}

		if (x.get(0) >= gridx) 
			return true;
		else if (x.get(0) < 0)
			return true;
			//System.out.println("D2");
		else if (y.get(0) >= gridy)
			return true;
		else if (y.get(0) < 0)
			return true;
		
		return false;
	}

}
