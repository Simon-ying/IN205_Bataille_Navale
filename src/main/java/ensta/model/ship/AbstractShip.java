package ensta.model.ship;

import ensta.util.Orientation;
public abstract class AbstractShip {
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
	protected boolean isSunk() {
		if (this.strikeCount == this.length) return true;
		else return false;
	}

}
