package ensta.model;

import java.io.Serializable;
import java.util.Random;

public class Coords implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	/*
	 * Constructeurs
	 */
	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Coords(Coords coords) {
		x = coords.getX();
		y = coords.getY();
	}
	
	public Coords() {
		x = 0;
		y = 0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;	
	}
	public void setY(int y) {
		this.y = y;	
	}
	public void setCoords(Coords res) {
		x = res.getX();
		y = res.getY();
		
	}
	public static Coords randomCoords(int size) {
		Random r = new Random();
		return new Coords(r.nextInt(size), r.nextInt(size));
	}
	public boolean isInBoard(int size) {
		return (x<size && x>=0 && y<size && y>=0);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}
