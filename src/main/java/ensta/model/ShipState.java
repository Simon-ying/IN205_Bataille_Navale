package ensta.model;
import ensta.model.ship.*;
import ensta.util.ColorUtil;
public class ShipState {
	private AbstractShip ref;
	private boolean struck;
	public void addStrike() {
		struck = true;
	}
	public boolean isStruck() {
		return struck;
	}
	public String toString() {
		return null;
	}
	public boolean isSunk() {
		return false;
	}
	public AbstractShip getShip() {
		return ref;
	}

}
