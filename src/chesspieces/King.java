package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class King extends Piece {

	boolean firstMove;

	public King(String player, int startIndex) {
		super(player, startIndex);
		this.firstMove = true;
	}

	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		if(!board[this.startIndex].piece.player.equals(player)) {
			return false;
		}
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