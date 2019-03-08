package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Pawn extends Piece {
	public Pawn(String player, int startIndex) {
		super(player,startIndex);
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
		ArrayList<Integer> moveList = getMoveList(this.startIndex,player,board);
		int endIndex = Piece.getIndex(end);
		if(moveList.contains(endIndex)) {
			if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
				Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
				this.firstMove = false;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return this.player + "p ";
	}
}