package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import chesspieces.*;

public class Chess {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Node[] board = new Node[64];
	static ArrayList<String> moveHistory = new ArrayList<String>();
	
	// Given player's king. Check if enemy is attacking.
	public static boolean attacked(int i, int j, String player) {
		// TODO Check all directions
		int row = i;
		int col = j;
		return false;
	}

	// Checking checkmate. Check if king is in checkmate. Check if there are no
	// valid moves from all pieces
	public static boolean kingIsChecked() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i*8+j].gridEmpty == false) {
					if (board[i*8+j].piece instanceof King) {
						String player = board[i*8+j].piece.player;
						if (attacked(i, j, player)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static void getNewMove(String player) throws IOException {
		System.out.println("Illegal Move, try again");
		
		if(player.equals("w")) {
			System.out.print("White's move: ");
			String next_move = reader.readLine();
			String[] splitted = next_move.split("\\s+");
			if (splitted.length == 1) {
				// 1 input: should be resign
				System.out.println("Black wins");
				System.exit(0);
			} else if (splitted.length == 2) {
				// 2 inputs
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
					getNewMove("w");
				}
			} else {
				// 3 inputs. Either draw or pawn promotion
				if (splitted[2].equals("draw")) {
					// TODO Offering draw
				} else {
					// TODO Pawn promotion
				}
			}
		} else {
			System.out.print("Black's move: ");
			String next_move = reader.readLine();
			String[] splitted = next_move.split("\\s+");
			if (splitted.length == 1) {
				// 1 input: should be resign
				System.out.println("White wins");
				System.exit(0);
			} else if (splitted.length == 2) {
				// 2 inputs
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
					getNewMove("b");
				}
			} else {
				// 3 inputs. Either draw or pawn promotion
				if (splitted[2].equals("draw")) {
					// TODO Offering draw
				} else {
					// TODO Pawn promotion
				}
			}
		}
	}
	
	public static void whiteMove() throws IOException {
		System.out.println("");
		System.out.print("White's move: ");
		String next_move = reader.readLine();
		String[] splitted = next_move.split("\\s+");

		// splitted[0] is initial location
		// splitted[1] is end location
		// splitted[2] is either draw or pawn promotion
		if (splitted.length == 1) {
			// 1 input: should be resign
			System.out.println("Black wins");
			return;
		} else if (splitted.length == 2) {
			// 2 inputs
			int initialIndex = Piece.getIndex(splitted[0]);
			if(board[initialIndex].piece.move(splitted[1], "w", board,moveHistory)==false) {
				getNewMove("w");
			}
		} else {
			// 3 inputs. Either draw or pawn promotion
			if (splitted[2].equals("draw")) {
				// TODO Offering draw
			} else {
				// TODO Pawn promotion
			}
		}
		System.out.println("");
		Node.print(board);
		blackMove();
	}

	public static void blackMove() throws IOException {
		System.out.println("");
		System.out.print("Black's move: ");
		String next_move = reader.readLine();
		String[] splitted = next_move.split("\\s+");
		if (splitted.length == 1) {
			// resign: 1 input
			System.out.println("White wins");
			return;
		} else if (splitted.length == 2) {
			int initialIndex = Piece.getIndex(splitted[0]);
			if(board[initialIndex].piece.move(splitted[1], "b", board,moveHistory)==false) {
				getNewMove("b");
			}
		} else {

		}
		System.out.println("");
		Node.print(board);
		whiteMove();
	}

	public static void main(String[] args) throws IOException {
		// Node[][] board = new Node[8][8];
		Node.initialize(board);
		Node.print(board);
		whiteMove();
	}

}
