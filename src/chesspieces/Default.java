package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Default extends Piece {
	
	public Default(String player, int startIndex) {
		super(player,startIndex);
	}

	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		return false;
	}
	
	public String toString() {
		return "default (empty)";
	}
}