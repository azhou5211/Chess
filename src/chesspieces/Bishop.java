package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Bishop extends Piece {

	public Bishop(String player) {
		super(player);
	}

	@Override
	void move(String initial, String end) {

	}
	
	public String toString() {
		return this.player + "B ";
	}
}