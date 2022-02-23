package ensta.ai;
import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;

public class PlayerAI extends Player {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public PlayerAI(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai instead.
    @Override
    public void putShips() throws Exception{
    	ai.putShips(ships);
    }
    @Override
    public Hit sendHit(Coords coords) {
    	return ai.sendHit(coords);
    }
}
