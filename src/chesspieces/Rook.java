package chesspieces;

import java.util.ArrayList;

/**
 * The Rook piece for chess.
 * This class allows moving the Rook and getting a list of all available moves for a particular Rook.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Rook extends Piece {
	
	/**
	 * Creates a new Rook
	 * @param player. The player which the Rook belongs to
	 * @param startIndex. The initial starting location of the Rook
	 */
	public Rook(String player, int startIndex) {
		super(player, startIndex);
	}
	
	/**
	 * Implementing the abstract method, getMoveList, from Piece.
	 * @param startIndex. Where the piece initially is located
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @return ArrayList of all indices where the Rook piece can move
	 */
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		// Going up
		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		for(int i=row-1;i>=0;i--) {
			if(board[i*8+col].gridEmpty) {
				moveList.add(i*8+col);
			} else {
				if(board[i*8+col].piece.player.equals(enemyPlayer)) {
					moveList.add(i*8+col);
				}
				break;
			}
		}
		
		// Going down
		for(int i=row+1;i<8;i++) {
			if(board[i*8+col].gridEmpty) {
				moveList.add(i*8+col);
			} else {
				if(board[i*8+col].piece.player.equals(enemyPlayer)) {
					moveList.add(i*8+col);
				}
				break;
			}
		}
		
		// Going left
		row = (int) Math.floor(startIndex/8);
		for(int i=startIndex-1;i>=row*8;i--) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
		}
		
		// Going right
		row++;
		for(int i=startIndex+1;i<row*8;i++) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
		}
		return moveList;
	}
	
	/**
	 * Implementing the abstract method, move, from Piece.
	 * @param end. User input to where the move should go
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @param moveHistory. An ArrayList of previous moves
	 * @return true, if the move was successfully executed.
	 * @return false, if the move was unsuccessfully executed (illegal move).
	 */
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		if(!board[this.startIndex].piece.player.equals(player)) {
			return false;
		}
		ArrayList<Integer> moveList = getMoveList(this.startIndex,player,board);
		int endIndex = Piece.getIndex(end);
		//Piece.RowColPrintList(moveList);
		if(moveList.contains(endIndex)) {
			if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
				Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
				this.firstMove = false;
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the string format for which the Rook piece is printed
	 */
	public String toString() {
		return this.player + "R ";
	}
}