package chesspieces;

import java.util.ArrayList;

import chess.Chess;
import chesspieces.King;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public abstract class Piece {
	public String player;
	public int startIndex;
	public boolean firstMove;
	
	// Need to add another arraylist to move to check if that move is allowed when checked by enemy
	// Also possible to check your own king by making a move..
	public abstract boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory);
	public abstract ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board);
	
	public static boolean executeMoveKingChecked(Node[] board, int startIndex, int endIndex, String player) {
		Piece temp = board[startIndex].piece;
		Piece temp2 = board[endIndex].piece;
		
		board[startIndex].gridEmpty = true;
		board[endIndex].gridEmpty = false;
		board[endIndex].piece = temp;
		board[endIndex].piece.startIndex = endIndex;
		board[startIndex].piece = new Default("null",-1);
		
		boolean kingChecked = false;
		
		int kingIndex=-1;
		if (player.equals("w")) {
			kingIndex = Chess.whiteKing.startIndex;
		} else {
			kingIndex = Chess.blackKing.startIndex;
		}
		
		if(King.isPositionChecked(board, kingIndex, player)) {
			kingChecked = true;
		}
		
		board[startIndex].gridEmpty = false;
		board[endIndex].gridEmpty = true;
		board[startIndex].piece = temp;
		board[startIndex].piece.startIndex = startIndex;
		board[endIndex].piece = temp2;
		
		return kingChecked;
	}
	
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
	
	public static int distance(String move) {
		String[] splitted = move.split("\\s+");
		int startIndex = Integer.parseInt(splitted[0]);
		int endIndex = Integer.parseInt(splitted[1]);
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;

		/*
		System.out.println("start row:" + startRow);
		System.out.println("end row:" + endRow);
		System.out.println("start col:" + startCol);
		System.out.println("end col:" + endCol);
		*/
		
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	
	public static int distance(int startIndex, int endIndex) {
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	
	public static String convertRowCol(int index) {
		int row = (int) Math.floor(index/8);
		int col = index%8;
		String ans = Integer.toString(row) + " " + Integer.toString(col);
		return ans;
	}
	
	public static void RowColPrintList(ArrayList<Integer> list) {
		for(Integer index: list) {
			int row = (int) Math.floor(index/8);
			int col = index%8;
			System.out.print("[" + row + " " + col + "],");
		}
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
		this.firstMove = true;
	}
}