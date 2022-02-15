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
	 * a implementer
	 * coordonnee
	 * --y
	 * |
	 * x
	 * 
	 * coords = end of boat
	 */
	
	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		if (hasShip(ship, coords)) return false;
		else {
			for (int isize=0; isize<ship.getLength(); isize++) {
				switch (ship.getOrientation()) {
				case NORTH:
				case SOUTH:
					this.navires[coords.getX() + ship.getOrientation().getIncrement()*isize][coords.getY()] 
							= ship.getLable();
					break;
				default:
					this.navires[coords.getX()][coords.getY() + ship.getOrientation().getIncrement()*isize] 
							= ship.getLable();
				}
				
			}
			return true;
		}
	}
	@Override
	public boolean hasShip(Coords coords) {
		if (!(coords.getX() < this.size &&
				coords.getY() < this.size &&
				coords.getX() >= 0 &&
				coords.getY() >= 0)) return true;
		else
			return (this.navires[coords.getX()][coords.getY()] != '.');
	}
	
	public boolean hasShip(AbstractShip ship, Coords coords) {
		for (int isize=0; isize<ship.getLength(); isize++) {
			Coords temp = new Coords(coords);
			switch (ship.getOrientation()) {
			case NORTH:
			case SOUTH:
				temp.setX(temp.getX()+ship.getOrientation().getIncrement()*isize);
				break;
			default:
				temp.setY(temp.getY()+ship.getOrientation().getIncrement()*isize);
			}
			if (this.hasShip(temp)) return true;
		}
		return false;
	}
	@Override
	public void setHit(boolean hit, Coords coords) {
		this.frappes[coords.getX()][coords.getY()] = hit;		
	}
	@Override
	public Boolean getHit(Coords coords) {
		return this.frappes[coords.getX()][coords.getY()];
	}
	@Override
	public Hit sendHit(Coords res) {
		switch (this.navires[res.getX()][res.getY()]) {
			case 'B':
				return Hit.fromInt(4);
			case 'C':
				return Hit.fromInt(5);
			case 'D':
				return Hit.fromInt(2);
			case 'S':
				return Hit.fromInt(3);
			default:
				return Hit.fromInt(-1);
		}
	}
}
