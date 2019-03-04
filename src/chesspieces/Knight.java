package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Knight extends Piece {

	public Knight(String player) {
		super(player);
	}

	@Override
	void move(String initial, String end, String player, Node[][] board) {

	}
	
	public String toString() {
		return this.player + "N ";
	}
}