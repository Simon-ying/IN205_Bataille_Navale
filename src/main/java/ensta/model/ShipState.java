package ensta.model;
import ensta.model.ship.*;
import ensta.util.ColorUtil;
public class ShipState {
	private AbstractShip ship = null;
	private boolean struck = false;
	private boolean isEnd = false;
	
	public ShipState() {
		ship = null;
		struck = false;
	}
	public void addStrike() {
		try {
			if (!struck && ship != null) {
				ship.addStrike();
				struck = true;
			}
		}
		catch (Exception e) {
			System.out.println("Error in 'addStrike()'!");
		}
		
	}
	public boolean isStruck() {
		return struck;
	}
	public String toString() {
		return ship.getLable() + ":" + ship.getName();
	}
	public boolean isSunk() {
		return false;
	}
	public AbstractShip getShip() {
		return ship;
	}
	public void setShip(AbstractShip ship) {
		this.ship = ship;
	}
	public void setEnd(boolean b) {
		isEnd = b;
	}
	public boolean getEnd() {
		return isEnd;
	}

}
