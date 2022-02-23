package ensta;

import java.util.ArrayList;
import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
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
//		zero.putShips();
		for (int i=0; i<ships.size(); i++) {
			board.putShip(ships.get(i), new Coords(i, 0));
		}
		
		Coords HitCoords = new Coords(0,0);
		Hit aHit = board.sendHit(HitCoords);
		board.setHit(aHit, HitCoords);
		board.print();
		
		HitCoords = new Coords(0,0);
		aHit = board.sendHit(HitCoords);
		board.setHit(aHit, HitCoords);
		board.print();
		
		HitCoords = new Coords(0,1);
		aHit = board.sendHit(HitCoords);
		board.setHit(aHit, HitCoords);
		board.print();
		
		HitCoords = new Coords(5,5);
		aHit = board.sendHit(HitCoords);
		board.setHit(aHit, HitCoords);
		board.print();
		
		HitCoords = new Coords(4,2);
		aHit = board.sendHit(HitCoords);
		board.setHit(aHit, HitCoords);
		board.print();
//		System.out.print(ColorUtil.colorize("Hello World with COLOR!!!", ColorUtil.Color.RED));
		

	}
}
