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
	void move(String initial, String end) {

	}
	
	public String toString() {
		return this.player + "Q ";
	}
}