package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Rook extends Piece {

	public Rook(String player) {
		super(player);
	}

	@Override
	void move(String initial, String end) {

	}
	
	public String toString() {
		return this.player + "R ";
	}
}