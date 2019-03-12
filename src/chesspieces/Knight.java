package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Knight extends Piece {

	public Knight(String player, int startIndex) {
		super(player, startIndex);
	}

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
		//System.out.println(moveList);
		return false;
	}

	public String toString() {
		return this.player + "N ";
	}
}