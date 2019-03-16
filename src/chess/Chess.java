package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import chesspieces.*;

/**
 * This is the main class. Running this class will bootup the chess game, and alternate between white and black turns.
 * This class also checks for stalemate and checkmate.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Chess {

	/**
	 *  global reader for input
	 */
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 *  global board
	 */
	static Node[] board = new Node[64];
	
	/**
	 *  global arraylist that keeps track of all moves
	 */
	public static ArrayList<String> moveHistory = new ArrayList<String>();
	
	/**
	 *  global white king and black king pieces
	 */
	public static Piece whiteKing;
	public static Piece blackKing;
	
	/**
	 *  global booleans to keep track if kings are checked
	 */
	private static boolean whiteChecked;
	private static boolean blackChecked;

	/**
	 * 
	 * @param which player it is
	 * @return True if there are no more moves left
	 */
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
	
	/**
	 * This method print's Illegal Move, try again, and asks for new input.
	 * @param player. Which player's turn it is
	 * @throws IOException. When the reader gets IO exception.
	 */
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
	
	/**
	 * This is white's turn. After a move is executed it checks if black is checkmated or stalemate.
	 * If black is not checkmated or in stalemate, then it turns to black's turn.
	 * @throws IOException. Reader gets bad input
	 */
	public static void whiteMove() throws IOException {
		System.out.println("");
		if(whiteChecked) {
			System.out.print("Checked ");
		}
		System.out.print("White's move: ");
		String next_move = reader.readLine();
		String[] splitted = next_move.split("\\s+");

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
		blackChecked = false;
		if(King.isPositionChecked(board, blackKing.startIndex, "b")) {
			if(isCheckmate("b")) {
				System.out.println("Checkmate");
				System.out.println("White wins");
				System.exit(0);
			} else {
				blackChecked = true;
			}
		} else {
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

	/**
	 * Black's move. After successfully executing a move, it will check if white is checkmated or stalemate.
	 * If not in checkmate or stalemate, it goes to white's turn.
	 * @throws IOException. IO exception for reader
	 */
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

	/**
	 * Main method that starts Chess.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Node.initialize(board);
		whiteKing = board[7*8+4].piece;
		blackKing = board[0*8+4].piece;
		whiteChecked = false;
		blackChecked = false;
		Node.print(board);
		whiteMove();
	}

}
