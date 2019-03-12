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

public class Chess {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Node[] board = new Node[64];
	public static ArrayList<String> moveHistory = new ArrayList<String>();
	public static Piece whiteKing;
	public static Piece blackKing;
	private static boolean whiteChecked;
	private static boolean blackChecked;

	private static boolean isCheckmate(String player) {
		for(int i=0;i<64;i++) {
			if(!board[i].gridEmpty) {
				if(board[i].piece.player.equals(player)) {
					ArrayList<Integer> moveList = board[i].piece.getMoveList(board[i].piece.startIndex, player, board);
					for(int move: moveList) {
						if(!Piece.executeMoveKingChecked(board, board[i].piece.startIndex, move, player)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void getNewMove(String player) throws IOException {
		System.out.println("Illegal Move, try again");
		
		if(player.equals("w")) {
			if(whiteChecked) {
				System.out.print("Checked ");
			}
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
				if (splitted[2].equals("draw?")) {
					// TODO Offering draw
					int initialIndex = Piece.getIndex(splitted[0]);
					if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
						getNewMove("w");
					} else {
						System.out.println("draw");
						System.exit(0);
					}
				} else {
					int initialIndex = Piece.getIndex(splitted[0]);
					int endIndex = Piece.getIndex(splitted[1]);
					if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
						getNewMove("w");
					} else {
						if(splitted[2].equals("R")) {
							board[endIndex].piece = new Rook("w",endIndex);
						} else if(splitted[2].equals("N")) {
							board[endIndex].piece = new Knight("w",endIndex);
						} else if(splitted[2].equals("B")) {
							board[endIndex].piece = new Bishop("w",endIndex);
						} else if(splitted[2].equals("Q")) {
							board[endIndex].piece = new Queen("w",endIndex);
						}
					}
				}
			}
		} else {
			if(blackChecked) {
				System.out.print("Checked ");
			}
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
				if (splitted[2].equals("draw?")) {
					// TODO Offering draw
					int initialIndex = Piece.getIndex(splitted[0]);
					if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
						getNewMove("b");
					} else {
						System.out.println("draw");
						System.exit(0);
					}
				} else {
					int initialIndex = Piece.getIndex(splitted[0]);
					int endIndex = Piece.getIndex(splitted[1]);
					if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
						getNewMove("b");
					} else {
						if(splitted[2].equals("R")) {
							board[endIndex].piece = new Rook("b",endIndex);
						} else if(splitted[2].equals("N")) {
							board[endIndex].piece = new Knight("b",endIndex);
						} else if(splitted[2].equals("B")) {
							board[endIndex].piece = new Bishop("b",endIndex);
						} else if(splitted[2].equals("Q")) {
							board[endIndex].piece = new Queen("b",endIndex);
						}
					}
				}
			}
		}
	}
	
	public static void whiteMove() throws IOException {
		System.out.println("");
		if(whiteChecked) {
			System.out.print("Checked ");
		}
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
			if (splitted[2].equals("draw?")) {
				// TODO Offering draw
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
					getNewMove("w");
				} else {
					System.out.println("draw");
					System.exit(0);
				}
			} else {
				int initialIndex = Piece.getIndex(splitted[0]);
				int endIndex = Piece.getIndex(splitted[1]);
				if(board[initialIndex].piece.move(splitted[1], "w", board, moveHistory)==false) {
					getNewMove("w");
				} else {
					if(splitted[2].equals("R")) {
						board[endIndex].piece = new Rook("w",endIndex);
					} else if(splitted[2].equals("N")) {
						board[endIndex].piece = new Knight("w",endIndex);
					} else if(splitted[2].equals("B")) {
						board[endIndex].piece = new Bishop("w",endIndex);
					} else if(splitted[2].equals("Q")) {
						board[endIndex].piece = new Queen("w",endIndex);
					}
				}
			}
		}
		//System.out.println("");
		blackChecked = false;
		if(King.isPositionChecked(board, blackKing.startIndex, "b")) {
			// Check for checkmate
			if(isCheckmate("b")) {
				//System.out.println("");
				System.out.println("Checkmate");
				System.out.println("White wins");
				System.exit(0);
			} else {
				blackChecked = true;
				//System.out.println("check ");
			}
		} else {
			// check for stalemate
			if(isCheckmate("b")) {
				System.out.println("Stalemate");
				System.out.println("draw");
				System.exit(0);
			}
		}
		System.out.println("");
		Node.print(board);
		blackMove();
	}

	public static void blackMove() throws IOException {
		System.out.println("");
		if(blackChecked) {
			System.out.print("Checked ");
		}
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
			if (splitted[2].equals("draw?")) {
				// TODO Offering draw
				int initialIndex = Piece.getIndex(splitted[0]);
				if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
					getNewMove("b");
				} else {
					System.out.println("draw");
					System.exit(0);
				}
			} else {
				int initialIndex = Piece.getIndex(splitted[0]);
				int endIndex = Piece.getIndex(splitted[1]);
				if(board[initialIndex].piece.move(splitted[1], "b", board, moveHistory)==false) {
					getNewMove("b");
				} else {
					if(splitted[2].equals("R")) {
						board[endIndex].piece = new Rook("b",endIndex);
					} else if(splitted[2].equals("N")) {
						board[endIndex].piece = new Knight("b",endIndex);
					} else if(splitted[2].equals("B")) {
						board[endIndex].piece = new Bishop("b",endIndex);
					} else if(splitted[2].equals("Q")) {
						board[endIndex].piece = new Queen("b",endIndex);
					}
				}
			}
		}
		// TODO Check for king is checked
		whiteChecked = false;
		if(King.isPositionChecked(board, whiteKing.startIndex, "w")) {
			// Check for checkmate
			if(isCheckmate("w")) {
				//System.out.println("");
				System.out.println("Checkmate");
				System.out.println("Black wins");
				System.exit(0);
			} else {
				whiteChecked = true;
				//System.out.println("Check ");
			}
		} else {
			// check for stalemate
			if(isCheckmate("w")) {
				System.out.println("Stalemate");
				System.out.println("draw");
				System.exit(0);
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
		blackKing = board[0*8+4].piece;
		whiteChecked = false;
		blackChecked = false;
		Node.print(board);
		whiteMove();
	}

}
