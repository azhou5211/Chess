package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public abstract class Piece {
	public String player;
	public abstract void move(String initial, String end, String player, Node[][] board);
	//public abstract boolean checkedKing(String initial);

	public Piece(String player) {
		this.player = player;
	}
}