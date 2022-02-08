package ensta.model.ship;

import ensta.util.Orientation;
public abstract class AbstractShip {
	private String name;
	private Orientation o;
	private int length;
	public Orientation getOrientation() {
		return o;
	}
	public int getLength() {
		return length;
	}
	public String getName() {
		return name;
	}
	protected abstract boolean isSunk();

}
