package chesspieces;

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
	public boolean move(String end, String player, Node[][] board) {
		// Current position. row = this.row. col = this.col
		int[] endIndex = Piece.getIndex(end);
		if(player.equals("w")) {
			if(firstMove == true) {
				
			}
		}
		return false;
	}
	
	public String toString() {
		return this.player + "p ";
	}
}