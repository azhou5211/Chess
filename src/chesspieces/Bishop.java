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
	public void move(String initial, String end, String player, Node[][] board) {
		// TODO Auto-generated method stub
	}
	
	public String toString() {
		return this.player + "B ";
	}
}