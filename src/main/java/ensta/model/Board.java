package ensta.model;

import java.io.Serializable;

import ensta.model.ship.AbstractShip;
import ensta.util.ColorUtil;
import ensta.util.Orientation;

public class Board implements IBoard, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public Coords lastHit;
	
	ShipState[][] navires;
	Hit[][] frappes; 
	
	/*
	 * Constructeurs
	 */
	public Board(String name, int size){
		this.name = name;
		this.size = size;
		navires = new ShipState[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				navires[irow][icol] = new ShipState();
			}
		}
		frappes = new Hit[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				frappes[irow][icol] = null;
			}
		}
	}
	public Board(String name) {
		this.name = name;
		this.size = DEFAULT_SIZE;
		navires = new ShipState[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				navires[irow][icol] = new ShipState();
			}
		}
		frappes = new Hit[size][size];
		for (int irow=0; irow<size; irow++) {
			for (int icol=0; icol<size; icol++) {
				frappes[irow][icol] = null;
			}
		}
	}
	private static String genSpace(int cst) throws Exception {
		if (cst < 0) {
			throw new Exception("Parameter must greater than 0");
		}
		String spaces = "";
		for (int i=0; i<cst; i++) {
			spaces += " ";
		}
		return spaces;
	}
	
	public void print() throws Exception {
		System.out.print("Navires: " + genSpace(5+2*size-"Navires: ".length()) + "Frappes: ");
		System.out.println();
		char c = 'A';
		int spaces = 0;
		System.out.print(genSpace(3));
		spaces += 3;
		for (int icol=0; icol<size; icol++) {
			System.out.print(c++ + genSpace(1));
			spaces += 2;
		}
		// reset c = 'A'
		c = 'A';
		System.out.print(genSpace(5+2*size-spaces+3));
		for (int icol=0; icol<size; icol++) {
			System.out.print(c++ + genSpace(1));
		}
		
		System.out.println();
		
		
		int i = 1;
		for (int irow=0; irow<size; irow++) {
			spaces = 0;
			System.out.print(i +((irow>8?genSpace(1):genSpace(2))));
			spaces += 3;
			for (int icol=0; icol<size; icol++) {
				if (navires[irow][icol].getShip()==null) {
					System.out.print("."+genSpace(1));
				}
				else if (navires[irow][icol].getShip()!=null && navires[irow][icol].getEnd()){
					System.out.print(ColorUtil.colorize(navires[irow][icol].getShip().getLable(), ColorUtil.Color.YELLOW)+genSpace(1));
				}
				else if (navires[irow][icol].getShip()!=null && navires[irow][icol].getShip().isSunk()){
					System.out.print(ColorUtil.colorize(navires[irow][icol].getShip().getLable(), ColorUtil.Color.RED)+genSpace(1));
				}
				else {
					System.out.print(navires[irow][icol].getShip().getLable()+genSpace(1));
				}
				spaces += 2;
			}
			System.out.print(genSpace(5+2*size-spaces) + i +((irow>8?genSpace(1):genSpace(2))));
			for (int icol=0; icol<size; icol++) {
				if (frappes[irow][icol]==null) {
					System.out.print("."+genSpace(1));
				}
				else if (frappes[irow][icol].getValue() == -1) {
					System.out.print("X"+genSpace(1));
				}
				else if (frappes[irow][icol].getValue() == -2){
					System.out.print(ColorUtil.colorize("X", ColorUtil.Color.RED)+genSpace(1));
				}
				else {
					System.out.print(ColorUtil.colorize("X", ColorUtil.Color.GREEN)+genSpace(1));
				}
			}
			System.out.println();
			i++;
		}
		System.out.println();
	}
	
	public void print(boolean cache) throws Exception {
		if (cache) {
			System.out.print("Navires: " + genSpace(5+2*size-"Navires: ".length()) + "Frappes: ");
			System.out.println();
			char c = 'A';
			int spaces = 0;
			System.out.print(genSpace(3));
			spaces += 3;
			for (int icol=0; icol<size; icol++) {
				System.out.print(c++ + genSpace(1));
				spaces += 2;
			}
			// reset c = 'A'
			c = 'A';
			System.out.print(genSpace(5+2*size-spaces+3));
			for (int icol=0; icol<size; icol++) {
				System.out.print(c++ + genSpace(1));
			}
			
			System.out.println();
			
			
			int i = 1;
			for (int irow=0; irow<size; irow++) {
				spaces = 0;
				System.out.print(i +((irow>8?genSpace(1):genSpace(2))));
				spaces += 3;
				for (int icol=0; icol<size; icol++) {
					if (frappes[irow][icol]==null) {
						System.out.print("*"+genSpace(1));
					}
					else if (navires[irow][icol].getShip()==null) {
						System.out.print("."+genSpace(1));
					}
					else if (navires[irow][icol].getShip()!=null && navires[irow][icol].getEnd()){
						System.out.print(ColorUtil.colorize(navires[irow][icol].getShip().getLable(), ColorUtil.Color.YELLOW)+genSpace(1));
					}
					else if (navires[irow][icol].getShip()!=null && navires[irow][icol].getShip().isSunk()){
						System.out.print(ColorUtil.colorize(navires[irow][icol].getShip().getLable(), ColorUtil.Color.RED)+genSpace(1));
					}
					else {
						System.out.print(navires[irow][icol].getShip().getLable()+genSpace(1));
					}
					spaces += 2;
				}
				System.out.print(genSpace(5+2*size-spaces) + i +((irow>8?genSpace(1):genSpace(2))));
				for (int icol=0; icol<size; icol++) {
					if (frappes[irow][icol]==null) {
						System.out.print("."+genSpace(1));
					}
					else if (frappes[irow][icol].getValue() == -1) {
						System.out.print("X"+genSpace(1));
					}
					else if (frappes[irow][icol].getValue() == -2){
						System.out.print(ColorUtil.colorize("X", ColorUtil.Color.RED)+genSpace(1));
					}
					else {
						System.out.print(ColorUtil.colorize("X", ColorUtil.Color.GREEN)+genSpace(1));
					}
				}
				System.out.println();
				i++;
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
					this.navires[coords.getX() + ship.getOrientation().getIncrement()*isize][coords.getY()].setShip(ship);
					break;
				default:
					this.navires[coords.getX()][coords.getY() + ship.getOrientation().getIncrement()*isize].setShip(ship);
				}
				
			}
			this.navires[coords.getX()][coords.getY()].setEnd(true);
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
			return (this.navires[coords.getX()][coords.getY()].getShip() != null);
	}
	
	@Override
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
	public void setHit(Hit hit, Coords coords) {
		this.frappes[coords.getX()][coords.getY()] = hit;		
	}
	@Override
	public Hit getHit(Coords coords) {
		return this.frappes[coords.getX()][coords.getY()];
	}
	@Override
	public Hit sendHit(Coords res) {
		this.navires[res.getX()][res.getY()].addStrike();
		if (this.navires[res.getX()][res.getY()].getShip()!=null) {
			if (this.navires[res.getX()][res.getY()].getShip().isSunk()) {
				
				switch (this.navires[res.getX()][res.getY()].getShip().getLable()) {
				case('B'):
					return Hit.fromInt(4);
				case('C'):
					return Hit.fromInt(5);
				case('D'):
					return Hit.fromInt(2);
				case('S'):
					return Hit.fromInt(3);
				default:
					return Hit.fromInt(-2);
				}
				
			}
			else return Hit.fromInt(-2);
					
		}
		else return Hit.fromInt(-1);
	}

}
