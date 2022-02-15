package ensta;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.util.Orientation;
import ensta.model.ship.*;
public class TestBoard {
	public static void main(String args[]) {
		Board b = new Board("Pacific");
		b.print();
		Battleship bs = new Battleship();
		boolean suc = b.putShip(bs, new Coords(4,4));
		b.print();
		System.out.println(suc);
	}
}
