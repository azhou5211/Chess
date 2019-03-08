package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Bishop extends Piece {

	public Bishop(String player, int startIndex) {
		super(player,startIndex);
	}

	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		// Going up left
		int i = startIndex-9;
		int col = (startIndex%8)-1;
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
	
	public String toString() {
		return this.player + "B ";
	}
}