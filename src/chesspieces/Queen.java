package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Queen extends Piece {

	public Queen(String player) {
		super(player);
	}

	@Override
	public void move(String initial, String end, String player, Node[][] board) {

	}
	
	public String toString() {
		return this.player + "Q ";
	}
}