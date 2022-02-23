package ensta.model.ship;

import ensta.util.Orientation;

public class Submarine extends AbstractShip {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Submarine(String name, Orientation o) {
		super(name, 'S', 3, o);
	}
	public Submarine(Orientation o) {
		super("Default_Submarine", 'S', 3, o);
	}
	public Submarine() {
		super("Default_Submarine", 'S', 3, Orientation.EAST);
	}

}
