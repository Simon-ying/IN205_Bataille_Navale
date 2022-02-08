package ensta.model.ship;

import ensta.util.Orientation;

public class Submarine extends AbstractShip {

	public Submarine(String name, Orientation o) {
		super(name, 'S', 3, o);
	}
	public Submarine(Orientation o) {
		super("Default_Submarine", 'S', 3, o);
	}
	public Submarine() {
		super("Default_Submarine", 'S', 3, Orientation.EAST);
	}

	@Override
	protected boolean isSunk() {
		// TODO Auto-generated method stub
		return false;
	}

}
