package chesspieces;

import java.util.ArrayList;

import chess.Chess;
import chesspieces.King;

/**
 * Abstract class. It is a super class for all pieces (Pawn, Rook, Knight, Bishop, Queen, King, and Default)
 * It provides two abstract methods which all pieces need to implement (getMoveList and move).
 * It also provides functionality such as executing a move, converting a string to an index, calculating distance of a move, and getting the enemy player.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public abstract class Piece {
	/**
	 * The player to which the piece belongs to
	 */
	public String player;
	
	/**
	 * The initial location of that piece
	 */
	public int startIndex;
	
	/**
	 * A boolean that is true if the piece has not moved yet.
	 */
	public boolean firstMove;
	
	/**
	 * 
	 * @param end. The end location to where to move should end up in.
	 * @param player. The player to which the piece belongs to
	 * @param board. The chess board
	 * @param moveHistory. An ArrayList of all previously made moves
	 * @return true if the move is executed, false otherwise
	 */
	public abstract boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory);
	
	/**
	 * Abstract method that needs to be implemented all other piece classes.
	 * It should return all possible moves of a particular chess piece.
	 * @param startIndex. The initial location of the piece
	 * @param player. The player to which the piece belongs to
	 * @param board. The chess board
	 * @return an ArrayList of all indices a particular chess piece can move to.
	 */
	public abstract ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board);
	
	/**
	 * This method temporarily executes a move to check if the king is in check. If the king is in check, the move is not valid, the method returns true.
	 * Before the method returns, the board is put back into it's original state.
	 * @param board. The chess board
	 * @param startIndex. The initial location of the piece
	 * @param endIndex. The end location of the piece
	 * @param player. The player to which the piece belongs to
	 * @return true if the king is checked after executing such a move, false if king is not checked after executing such a move. 
	 */
	public static boolean executeMoveKingChecked(Node[] board, int startIndex, int endIndex, String player) {
		Piece temp = board[startIndex].piece;
		boolean endIndexEmpty = board[endIndex].gridEmpty;
		Piece temp2 = board[endIndex].piece;
		
		board[startIndex].gridEmpty = true;
		board[endIndex].gridEmpty = false;
		board[endIndex].piece = temp;
		temp.startIndex = endIndex;
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
		board[endIndex].gridEmpty = endIndexEmpty;
		board[startIndex].piece = temp;
		temp.startIndex = startIndex;
		board[endIndex].piece = temp2;
		
		return kingChecked;
	}
	
	/**
	 * Calculates the index of a given FileRank.
	 * @param FileRank. String of a FileRank
	 * @return index. the int index of a given File and Rank
	 */
	public static int getIndex(String FileRank) {
		int index;
		char File = FileRank.charAt(0);
		char Rank = FileRank.charAt(1);
		int col = File - 'a';
		int row = 8 - (Rank - '0');
		index = 8*row + col;
		return index;
	}
	
	/**
	 * This method executes the move on to the board. It moves the piece from an initial location to the end location.
	 * The initial location is then set to an empty grid, and takes on a default piece.
	 * @param board. Chess board
	 * @param startIndex. The initial location of the piece
	 * @param endIndex. The end location of the piece
	 * @param moveHistory. The moveHistory of the piece. executeMove appends the startIndex and endIndex into the movehistory as a string
	 */
	public static void executeMove(Node[] board, int startIndex, int endIndex, ArrayList<String> moveHistory) {
		board[endIndex].gridEmpty = false;
		board[startIndex].gridEmpty = true;
		board[endIndex].piece = board[startIndex].piece;
		board[endIndex].piece.startIndex = endIndex;
		board[startIndex].piece = new Default("null",-1);
		String history = Integer.toString(startIndex) + " " + Integer.toString(endIndex);
		moveHistory.add(history);
	}
	
	/**
	 * Calculates the distance between two locations. (Mainly used for en passant)
	 * @param move. String that has two FileRanks.
	 * @return distance. An int of the two distances between the two locations.
	 */
	public static int distance(String move) {
		String[] splitted = move.split("\\s+");
		int startIndex = Integer.parseInt(splitted[0]);
		int endIndex = Integer.parseInt(splitted[1]);
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	
	/**
	 * Overloaded method to calculate distances.
	 * Calculates the distance between two locations. (Mainly used for en passant)
	 * @param move. String that has two FileRanks.
	 * @return distance. An int of the two distances between the two locations.
	 */
	public static int distance(int startIndex, int endIndex) {
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	
	/**
	 * A method that converts an index into a row and col location.
	 * Used to check the row and col location of a given index
	 * @param index.
	 * @return String format of row location and col location
	 */
	public static String convertRowCol(int index) {
		int row = (int) Math.floor(index/8);
		int col = index%8;
		String ans = Integer.toString(row) + " " + Integer.toString(col);
		return ans;
	}
	
	/**
	 * @param list. ArrayList of moves in index format
	 * Prints out the moves in row and col format. Used for debugging.
	 */
	public static void RowColPrintList(ArrayList<Integer> list) {
		for(Integer index: list) {
			int row = (int) Math.floor(index/8);
			int col = index%8;
			System.out.print("[" + row + " " + col + "],");
		}
	}
	
	/**
	 * @param player. Current player.
	 * @return String of the enemy player.
	 */
	public static String getEnemyPlayer(String player) {
		if(player.equals("w")) {
			return "b";
		} else {
			return "w";
		}
	}
	
	/**
	 * Creates a static type Piece object, dynamic type of (Pawn, Rook, Knight, Bishop, Queen, King, and Default).
	 * @param player. Player to which the piece belongs to
	 * @param startIndex. The initial location of the piece.
	 * Sets firstMove to true for all newly constructed pieces.
	 */
	public Piece(String player, int startIndex) {
		this.player = player;
		this.startIndex = startIndex;
		this.firstMove = true;
	}
}