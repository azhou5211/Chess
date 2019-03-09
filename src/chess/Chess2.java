package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import chesspieces.*;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Chess2 {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Node[] board = new Node[64];
	public static ArrayList<String> moveHistory = new ArrayList<String>();
	public static Piece whiteKing;
	public static Piece blackKing;

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
					int initialIndex = Piece.getIndex(splitted[0]);
					if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
						getNewMove("w");
					}
				} else {
					int initialIndex = Piece.getIndex(splitted[0]);
					int endIndex = Piece.getIndex(splitted[1]);
					if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
						getNewMove("w");
					} else {
						if(splitted[0].equals("R")) {
							board[endIndex].piece = new Rook("w",endIndex);
						} else if(splitted[0].equals("N")) {
							board[endIndex].piece = new Knight("w",endIndex);
						} else if(splitted[0].equals("B")) {
							board[endIndex].piece = new Bishop("w",endIndex);
						} else if(splitted[0].equals("Q")) {
							board[endIndex].piece = new Queen("w",endIndex);
						}
					}
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
				if(board[initialIndex].piece.move(splitted[1], "b", board,moveHistory)==false) {
					getNewMove("b");
				}
			} else {
				// 3 inputs. Either draw or pawn promotion
				if (splitted[2].equals("draw")) {
					// TODO Offering draw
					int initialIndex = Piece.getIndex(splitted[0]);
					if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
						getNewMove("b");
					}
				} else {
					int initialIndex = Piece.getIndex(splitted[0]);
					int endIndex = Piece.getIndex(splitted[1]);
					if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
						getNewMove("b");
					} else {
						if(splitted[0].equals("R")) {
							board[endIndex].piece = new Rook("b",endIndex);
						} else if(splitted[0].equals("N")) {
							board[endIndex].piece = new Knight("b",endIndex);
						} else if(splitted[0].equals("B")) {
							board[endIndex].piece = new Bishop("b",endIndex);
						} else if(splitted[0].equals("Q")) {
							board[endIndex].piece = new Queen("b",endIndex);
						}
					}
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
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
					getNewMove("w");
				}
			} else {
				int initialIndex = Piece.getIndex(splitted[0]);
				int endIndex = Piece.getIndex(splitted[1]);
				if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
					getNewMove("w");
				} else {
					if(splitted[0].equals("R")) {
						board[endIndex].piece = new Rook("w",endIndex);
					} else if(splitted[0].equals("N")) {
						board[endIndex].piece = new Knight("w",endIndex);
					} else if(splitted[0].equals("B")) {
						board[endIndex].piece = new Bishop("w",endIndex);
					} else if(splitted[0].equals("Q")) {
						board[endIndex].piece = new Queen("w",endIndex);
					}
				}
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
			// 3 inputs. Either draw or pawn promotion
			if (splitted[2].equals("draw")) {
				// TODO Offering draw
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
					getNewMove("b");
				}
			} else {
				int initialIndex = Piece.getIndex(splitted[0]);
				int endIndex = Piece.getIndex(splitted[1]);
				if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
					getNewMove("b");
				} else {
					if(splitted[0].equals("R")) {
						board[endIndex].piece = new Rook("b",endIndex);
					} else if(splitted[0].equals("N")) {
						board[endIndex].piece = new Knight("b",endIndex);
					} else if(splitted[0].equals("B")) {
						board[endIndex].piece = new Bishop("b",endIndex);
					} else if(splitted[0].equals("Q")) {
						board[endIndex].piece = new Queen("b",endIndex);
					}
				}
			}
		}
		System.out.println("");
		Node.print(board);
		whiteMove();
	}

	public static void main(String[] args) throws IOException {
		// Node[][] board = new Node[8][8];
		Node.initialize(board);
		whiteKing = board[7*8+4].piece;
		//whiteKing = board[3*8+2].piece;
		blackKing = board[0*8+4].piece;
		Node.print(board);
		whiteMove();
	}

}
