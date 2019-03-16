package chesspieces;

import java.util.ArrayList;

/**
 * The Knight piece for chess.
 * This class allows moving the Knight and getting a list of all available moves for a particular Knight.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Knight extends Piece {

	/**
	 * Creates a new Knight
	 * @param player. The player which the Knight belongs to
	 * @param startIndex. The initial starting location of the Knight
	 */
	public Knight(String player, int startIndex) {
		super(player, startIndex);
	}

	/**
	 * Implementing the abstract method, getMoveList, from Piece.
	 * @param startIndex. Where the piece initially is located
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @return ArrayList of all indices where the Knight piece can move
	 */
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		int tempIndex1 = startIndex - 10; // left up
		int tempIndex2 = startIndex - 17; // up left
		int tempIndex3 = startIndex - 15; // up right
		int tempIndex4 = startIndex - 6; // right up
		int tempIndex5 = startIndex + 10; // right down
		int tempIndex6 = startIndex +17; // down right
		int tempIndex7 = startIndex +15; // down left
		int tempIndex8 = startIndex + 6; // left down
		
		if(tempIndex1 >= 0 && row-1>=0 && col-2>=0) {
			if(board[tempIndex1].gridEmpty) {
				moveList.add(tempIndex1);
			} else {
				if(board[tempIndex1].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex1);
				}
			}
		}
		
		if(tempIndex2 >= 0 && row-2>=0 && col-1>=0) {
			if(board[tempIndex2].gridEmpty) {
				moveList.add(tempIndex2);
			} else {
				if(board[tempIndex2].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex2);
				}
			}
		}
		
		if(tempIndex3 >= 0  && row-2>=0 && col+1<8) {
			if(board[tempIndex3].gridEmpty) {
				moveList.add(tempIndex3);
			} else {
				if(board[tempIndex3].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex3);
				}
			}
		}
		
		if(tempIndex4 >= 0 && row-1>=0 && col+2<8) {
			if(board[tempIndex4].gridEmpty) {
				moveList.add(tempIndex4);
			} else {
				if(board[tempIndex4].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex4);
				}
			}
		}
		
		if(tempIndex5 < 64 && row+1<8 && col+2<8) {
			if(board[tempIndex5].gridEmpty) {
				moveList.add(tempIndex5);
			} else {
				if(board[tempIndex5].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex5);
				}
			}
		}
		
		if(tempIndex6 < 64 && row+2<8 && col+1<8) {
			if(board[tempIndex6].gridEmpty) {
				moveList.add(tempIndex6);
			} else {
				if(board[tempIndex6].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex6);
				}
			}
		}
		
		if(tempIndex7 < 64 && row+2<8 && col-1>=0) {
			if(board[tempIndex7].gridEmpty) {
				moveList.add(tempIndex7);
			} else {
				if(board[tempIndex7].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex7);
				}
			}
		}
		
		if(tempIndex8 < 64 && row+1<8 && col-2>=0) {
			if(board[tempIndex8].gridEmpty) {
				moveList.add(tempIndex8);
			} else {
				if(board[tempIndex8].piece.player.equals(enemyPlayer)) {
					moveList.add(tempIndex8);
				}
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
		if(moveList.contains(endIndex)) {
			if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
				Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the string format for which the Knight piece is printed
	 */
	public String toString() {
		return this.player + "N ";
	}
}