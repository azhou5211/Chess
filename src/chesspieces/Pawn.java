package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Pawn extends Piece {
	
	boolean firstMove;
	
	public Pawn(String player) {
		super(player);
		this.firstMove = true;
	}

	@Override
	void move(String initial, String end, String player, Node[][] board) {
		if(firstMove) {
			
		}
	}
	
	public String toString() {
		return this.player + "p ";
	}
}