package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import chesspieces.Node;

public class Chess {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void blackMove(Node[][] board) throws IOException {
		System.out.println("");
		System.out.print("Black's move: ");
		String next_move = reader.readLine(); 
		System.out.println("");
		Node.print(board);
		whiteMove(board);
	}
	
	public static void whiteMove(Node[][] board) throws IOException {
		System.out.println("");
		System.out.print("White's move: ");
		String next_move = reader.readLine(); 
		System.out.println("");
		Node.print(board);
		blackMove(board);
	}
	
	
	public static void main(String[] args) throws IOException {
		Node[][] board = new Node[8][8];
		Node.initialize(board);
		Node.print(board);
		whiteMove(board);
	}

}
