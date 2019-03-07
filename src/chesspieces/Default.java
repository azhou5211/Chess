package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Default extends Piece {
	
	public Default(String player,int row, int col) {
		super(player,row,col);
	}

	@Override
	public boolean move(String end, String player, Node[][] board, ArrayList<String> moveHistory) {
		return false;
	}
	
	public String toString() {
		return "default (empty)";
	}
}