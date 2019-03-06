package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import chesspieces.*;

public class Chess {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Node[][] board = new Node[8][8];
	
	// Given player's king. Check if enemy is attacking.
	public static boolean attacked(int i,int j, String player) {
		// TODO Check all directions
		int row = i;
		int col = j;
		return false;
	}
	
	// Checking checkmate. Check if king is in checkmate. Check if there are no valid moves from all pieces	
	public static boolean kingIsChecked() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j].gridEmpty==false) {
					if(board[i][j].piece instanceof King) {
						String player = board[i][j].piece.player;
						if(attacked(i,j,player)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public static void whiteMove() throws IOException {
		System.out.println("");
		System.out.print("White's move: ");
		String next_move = reader.readLine();
		String[] splitted = next_move.split("\\s+");
		String initial = splitted[0];
		String end = splitted[1];
		// System.out.println(splitted.length);
		// Pawn may have 3 inputs
		// Draw has 3 inputs
		// usually 2 inputs for ordinary pieces
		// resign: 1 input
		
		System.out.println("");
		Node.print(board);
		blackMove();
	}
	
	public static void blackMove() throws IOException {
		System.out.println("");
		System.out.print("Black's move: ");
		String next_move = reader.readLine();
		String[] splitted = next_move.split("\\s+");
		String initial = splitted[0];
		String end = splitted[1];
		
		System.out.println("");
		Node.print(board);
		whiteMove();
	}
	
	public static void main(String[] args) throws IOException {
		//Node[][] board = new Node[8][8];
		Node.initialize(board);
		Node.print(board);
		whiteMove();
	}

}
