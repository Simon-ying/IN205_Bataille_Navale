package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	/* 
	 * Atributs
	 * name : nom de Board
	 * size : taille de la grille
	 * navires : tableau 2D pour les navires
	 * frappes : tableau 2D pour les frappes 
	 */
	
	private String name;
	public String getName() {
		return name;
	}
	
	private int size;
	public int getSize() {
		return size;
	}
	
	char[][] navires;
	boolean[][] frappes; 
	
	/*
	 * Constructeurs
	 */
	public Board(String name, int size){
		this.name = name;
		this.size = size;
		navires = new char[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				navires[irow][icol] = '.';
			}
		}
		frappes = new boolean[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				frappes[irow][icol] = false;
			}
		}
	}
	public Board(String name) {
		this.name = name;
		this.size = DEFAULT_SIZE;
		navires = new char[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				navires[irow][icol] = '.';
			}
		}
		frappes = new boolean[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				frappes[irow][icol] = false;
			}
		}
	}

	public void print() {
		System.out.println("Navires: ");
		
		char c = 'A';
		int i = 1;
		System.out.print("   ");
		for (int icol=0; icol<size; icol++) {
			System.out.print(c++ +" ");
		}
		System.out.println();
		for (int irow=0; irow<size; irow++) {
			System.out.print(i++ +((irow>8?" ":"  ")));
			for (int icol=0; icol<size; icol++) {
				System.out.print(navires[irow][icol]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Frappes: ");
		c = 'A';
		i = 1;
		System.out.print("   ");
		for (int icol=0; icol<size; icol++) {
			System.out.print(c++ +" ");
		}
		System.out.println();
		for (int irow=0; irow<size; irow++) {
			System.out.print(i++ +((irow>8?" ":"  ")));
			for (int icol=0; icol<size; icol++) {
				System.out.print((frappes[irow][icol]?'x':'.') + " ");
			}
			System.out.println();
		}
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}
	
	/*
	 * non implementer
	 */
	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasShip(Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setHit(boolean hit, Coords coords) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean getHit(Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
}
