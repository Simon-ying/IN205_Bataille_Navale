package ensta;

import java.util.ArrayList;
import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Player;
import ensta.util.ColorUtil;
import ensta.util.Orientation;
import ensta.model.ship.*;
public class TestBoard {
	public static void main(String args[]) throws Exception {
		Board board = new Board("Player");
		Board opponentBoard = new Board("Opponent");
		List<AbstractShip> ships = new ArrayList<>();
		ships.add(new Destroyer());
		ships.add(new Submarine());
		ships.add(new Submarine());
		ships.add(new Battleship());
		ships.add(new Carrier());
		
		Player zero = new Player(board, opponentBoard, ships);
		zero.putShips();
//		System.out.print(ColorUtil.colorize("Hello World with COLOR!!!", ColorUtil.Color.RED));
		

	}
}
