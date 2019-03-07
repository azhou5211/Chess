package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Pawn extends Piece {
	
	boolean firstMove;
	
	public Pawn(String player, int row, int col) {
		super(player,row,col);
		this.firstMove = true;
	}

	@Override
	public boolean move(String end, String player, Node[][] board, ArrayList<String> moveHistory) {
		// Current position. row = this.row. col = this.col
		int row = this.row;
		int col = this.col;
		int[] endIndex = Piece.getIndex(end);
		boolean checkEndIndex = false;
		
		
		return false;
	}
	
	public String toString() {
		return this.player + "p ";
	}
}