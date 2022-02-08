package ensta.model.ship;

import ensta.util.Orientation;
public abstract class AbstractShip {
	private char lable;
	private String name;
	private Orientation o;
	private int length;
	
	public AbstractShip(String name, char lable, int length, Orientation o) {
		this.name = name;
		this.lable = lable;
		this.length = length;
		this.o = o;
	}
	
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
	protected abstract boolean isSunk();

}
