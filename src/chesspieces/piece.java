package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public abstract class Piece {
	String player;
	abstract void move(String initial, String end);
	
	public Piece(String player) {
		this.player = player;
	}
}