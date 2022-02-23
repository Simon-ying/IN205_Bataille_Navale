package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Destroyer(String name,Orientation o) {
		super(name, 'D', 2, o);
	}
	public Destroyer(Orientation o) {
		super("Default_Destroyer", 'D', 2, o);
	}
	public Destroyer() {
		super("Default_Destroyer", 'D', 2, Orientation.EAST);
	}


}
