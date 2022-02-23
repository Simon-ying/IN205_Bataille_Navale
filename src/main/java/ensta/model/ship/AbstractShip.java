package ensta.model.ship;

import java.io.Serializable;

import ensta.util.Orientation;
public abstract class AbstractShip implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char lable;
	private String name;
	private Orientation o;
	private int length;
	private int strikeCount = 0;
	
	public AbstractShip(String name, char lable, int length, Orientation o) {
		this.name = name;
		this.lable = lable;
		this.length = length;
		this.o = o;
	}
	
	/*
	 * mutateur pour l'orientation
	 */
	public void setOrientation(Orientation o) {
		this.o = o;
	}
	
	public Orientation getOrientation() {
		return o;
	}
	public int getLength() {
		return length;
	}
	public String getName() {
		return name;
	}
	public char getLable() {
		return lable;
	}
	
	public void addStrike() {
		this.strikeCount ++;
	}
	public boolean isSunk() {
		if (this.strikeCount >= Math.max(2, this.length-2)) return true;
		else return false;
	}

}
