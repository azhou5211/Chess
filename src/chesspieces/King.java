package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class King extends Piece {

	boolean firstMove;

	public King(String player,int row, int col) {
		super(player,row,col);
		this.firstMove = true;
	}

	@Override
	public boolean move(String end, String player, Node[][] board) {
		/**
		 * Castling Rules
		 * Your king has been moved earlier in the game. 
		 * The rook that you would castle with has been moved earlier in the game. 
		 * There are pieces standing between your king and rook. 
		 * The king is in check. 
		 * The king moves through a square that is attacked by a piece of the opponent. 
		 * The king would be in check after castling.
		 */
		return false;
	}

	public String toString() {
		return this.player + "K ";
	}
}