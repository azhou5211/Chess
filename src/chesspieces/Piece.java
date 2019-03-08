package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public abstract class Piece {
	public String player;
	public int startIndex;
	public abstract boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory);
	public abstract ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board);
	
	public static int getIndex(String FileRank) {
		int index;
		char File = FileRank.charAt(0);
		char Rank = FileRank.charAt(1);
		int col = File - 'a';
		int row = 8 - (Rank - '0');
		index = 8*row + col;
		return index;
	}
	
	public static void executeMove(Node[] board, int startIndex, int endIndex, ArrayList<String> moveHistory) {
		board[endIndex].gridEmpty = false;
		board[startIndex].gridEmpty = true;
		board[endIndex].piece = board[startIndex].piece;
		board[endIndex].piece.startIndex = endIndex;
		board[startIndex].piece = new Default("null",-1);
		String history = Integer.toString(startIndex) + " " + Integer.toString(endIndex);
		moveHistory.add(history);
	}
	
	public static String convertRowCol(int index) {
		int row = (int) Math.floor(index/8);
		int col = index%8;
		String ans = Integer.toString(row) + " " + Integer.toString(col);
		return ans;
	}
	
	public static String getEnemyPlayer(String player) {
		if(player.equals("w")) {
			return "b";
		} else {
			return "w";
		}
	}
	
	public Piece(String player, int startIndex) {
		this.player = player;
		this.startIndex = startIndex;
	}
}