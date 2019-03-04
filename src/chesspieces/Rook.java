package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Rook extends Piece {
	
	boolean firstMove;
	
	public Rook(String player) {
		super(player);
		this.firstMove = true;
	}

	@Override
	void move(String initial, String end, String player, Node[][] board) {

	}
	
	public String toString() {
		return this.player + "R ";
	}
}