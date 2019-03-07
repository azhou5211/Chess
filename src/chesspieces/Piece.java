package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public abstract class Piece {
	public String player;
	public int row;
	public int col;
	public abstract boolean move(String end, String player, Node[][] board, ArrayList<String> moveHistory);
	//public abstract boolean checkedKing(String initial);
	
	public static int[] getIndex(String FileRank) {
		int[] index = new int[2];
		char File = FileRank.charAt(0);
		char Rank = FileRank.charAt(1);
		index[1] = File - 'a';
		index[0] = 8 - (Rank - '0');
		return index;
	}
	
	public static void executeMove(Node[][] board, int[] endIndex, int row, int col, ArrayList<String> moveHistory) {
		board[endIndex[0]][endIndex[1]].gridEmpty = false;
		board[row][col].gridEmpty = true;
		board[endIndex[0]][endIndex[1]].piece = board[row][col].piece;
		board[endIndex[0]][endIndex[1]].piece.row = endIndex[0];
		board[endIndex[0]][endIndex[1]].piece.col = endIndex[1];
		board[row][col].piece = new Default("null",-1,-1);
		String history = Integer.toString(row) + Integer.toString(col) +  " " + Integer.toString(endIndex[0]) + Integer.toString(endIndex[1]);
		moveHistory.add(history);
	}
	
	public static String getEnemyPlayer(String player) {
		if(player.equals("w")) {
			return "b";
		} else {
			return "w";
		}
	}
	
	public Piece(String player, int row, int col) {
		this.player = player;
		this.row = row;
		this.col = col;
	}
}