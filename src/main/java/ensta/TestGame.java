package ensta;

import java.util.ArrayList;
import java.util.List;

import ensta.ai.BattleShipsAI;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.Battleship;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;

public class TestGame {
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		Board board = new Board("Player");
		board.print();
//		Board opponentBoard = new Board("Opponent");
		
		BattleShipsAI ai = new BattleShipsAI(board, board);
		
		List<AbstractShip> ships = new ArrayList<>();
//		ships.add(new Destroyer());
//		ships.add(new Submarine());
		ships.add(new Submarine());
//		ships.add(new Battleship());
		ships.add(new Carrier());
		
		int num_ships = ships.size();
		int num_sunk = 0;
		
		ai.putShips(ships.toArray(new AbstractShip[0]));
		board.print();
		
		while (num_sunk < num_ships) {
			num_sunk = 0;
			ai.sendHit(new Coords(0,0));
			for (int i=0; i<num_ships; i++) {
				if (ships.get(i).isSunk()) {
					num_sunk++;
				}
			}
			board.print();
			sleep(120);
		}
//		Player zero = new Player(board, board, ships);
//		zero.putShips();
		
	}
}
