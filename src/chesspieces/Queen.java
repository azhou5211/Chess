package chesspieces;

import java.util.ArrayList;

/**
 * The Queen piece for chess.
 * This class allows moving the Queen and getting a list of all available moves for a particular Queen.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Queen extends Piece {

	/**
	 * Creates a new Queen
	 * @param player. The player which the Queen belongs to
	 * @param startIndex. The initial starting location of the Queen
	 */
	public Queen(String player, int startIndex) {
		super(player,startIndex);
	}

	/**
	 * Implementing the abstract method, getMoveList, from Piece.
	 * @param startIndex. Where the piece initially is located
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @return ArrayList of all indices where the Queen piece can move
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
		
		// Going up left
		int i = startIndex-9;
		col = (startIndex%8)-1;
		while(col>=0 && i>=0) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
			i-=9;
			col--;
		}
		
		// Going down right
		i = startIndex+9;
		col = (startIndex%8)+1;
		while(col<8 && i<64) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
			i+=9;
			col++;
		}
		
		// Going up right
		i = startIndex-7;
		col = (startIndex%8)+1;
		while(col<8 && i>=0) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
			i-=7;
			col++;
		}
		
		// Going down left
		i = startIndex+7;
		col = (startIndex%8)-1;
		while(col>=0 && i<64) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
			i+=7;
			col--;
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
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the string format for which the Queen piece is printed
	 */
	public String toString() {
		return this.player + "Q ";
	}
}