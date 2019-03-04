package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class King extends Piece {

	public King(String player) {
		super(player);
	}

	@Override
	void move(String initial, String end) {

	}
	
	public String toString() {
		return this.player + "K ";
	}
}