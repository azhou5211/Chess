package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Pawn extends Piece {
	
	boolean firstMove;
	
	public Pawn(String player, int startIndex) {
		super(player,startIndex);
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
		
		
		return false;
	}
	
	public String toString() {
		return this.player + "p ";
	}
}