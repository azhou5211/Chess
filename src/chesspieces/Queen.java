package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Queen extends Piece {

	public Queen(String player, int row,int col) {
		super(player,row,col);
	}

	@Override
	public boolean move(String end, String player, Node[][] board) {
		return false;
	}
	
	public String toString() {
		return this.player + "Q ";
	}
}