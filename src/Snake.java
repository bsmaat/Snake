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
	int size = 10;
	int direc = 0;
	int inc = 5;
	int joints;
	int snakeSize = 10;

	public Snake() {

		for (int i=0; i<snakeSize; i++) {
			x.add(i*10);
			y.add(30);
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
		g.setColor(Color.BLACK);
		for(int i=0; i<x.size(); i++) {
			g.fillRect(x.get(i), y.get(i), size, size);	
			//System.out.println(i + " " + x.get(i));
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
			x.set(0,x.get(0)+2*inc);
			break;
		case(1):
			//x[0] -= inc;
			x.set(0,x.get(0)-2*inc);
			break;
		case(2):
			y.set(0,y.get(0)+2*inc);
			break;
		case(3):
			//y[0] -= inc;
			y.set(0,y.get(0)-2*inc);
			break;			
		}
/**		for(Integer[] i : x) {
			
		}
	*/

	}
}
