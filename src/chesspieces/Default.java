package chesspieces;

import java.util.ArrayList;

/**
 * 
 * The Default piece is a piece where the chess board is actually empty.
 * Instead of having null in the empty chess board spots, we have default
 * that will return false and null for any moves or move lists, respectively.
 * 
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Default extends Piece {
	
	/**
	 * Creates a default piece. default piece is actually where the chess board is empty.
	 * @param player of which this piece belongs to 
	 * @param startIndex is the index where the piece initially belongs
	 * 
	 */
	public Default(String player, int startIndex) {
		super(player,startIndex);
	}

	/**
	 * Implementing the abstract method, getMoveList, from Piece.
	 * Since this is a default piece, there is are no moves, and therefore returns null
	 * @param startIndex. Where the piece initially is located
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @return null. Since there are no moves for default piece.
	 */
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		return null;
	}
	
	/**
	 * Implementing the abstract method, move, from Piece.
	 * Since this is a default piece, there are no moves, and therefore returns false
	 * @param end. User input to where the move should go
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @param moveHistory. An ArrayList of all previous moves.
	 * @return false. There are no moves for default piece, and therefore moving was unsuccessful, so returning false.
	 */
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		return false;
	}
	
	/**
	 * @return the string format for which the default piece is printed
	 */
	public String toString() {
		return "default (empty)";
	}
}