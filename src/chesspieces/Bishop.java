package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Bishop extends Piece {

	public Bishop(String player,int row, int col) {
		super(player,row,col);
	}

	@Override
	public boolean move(String end, String player, Node[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return this.player + "B ";
	}
}