package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Rook extends Piece {
	public Rook(String player, int startIndex) {
		super(player, startIndex);
	}
	
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		// Going up
		for(int i=startIndex-8;i>=0;i-=8) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
		}
		
		// Going down
		for(int i=startIndex+8;i<64;i+=8) {
			if(board[i].gridEmpty) {
				moveList.add(i);
			} else {
				if(board[i].piece.player.equals(enemyPlayer)) {
					moveList.add(i);
				}
				break;
			}
		}
		
		// Going left
		int row = (int) Math.floor(startIndex/8);
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
		return this.player + "R ";
	}
}