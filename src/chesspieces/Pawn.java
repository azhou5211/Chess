package chesspieces;

import java.util.ArrayList;

import chess.Chess;

/**
 * The Pawn piece for chess.
 * This class allows moving the Pawn and getting a list of all available moves for a particular Pawn.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Pawn extends Piece {
	
	/**
	 * Creates a new Pawn
	 * @param player. The player which the Pawn belongs to
	 * @param startIndex. The initial starting location of the Pawn
	 */
	public Pawn(String player, int startIndex) {
		super(player,startIndex);
	}
	
	/**
	 * a boolean that is set true if the move being executed is an en passant move.
	 */
	private static boolean enpassant;

	/**
	 * When making an en passant move, it checks if the previous move was a pawn moving two blocks forward.
	 * @param previousMove. A string that is the previous move that was executed in the game.
	 * @param index. The end location of where the en passant move
	 * @return true, if the previous move was an enemy pawn moving two blocks forward
	 * @return false, if the previous move was not an enemy pawn, or a pawn moving two blocks
	 */
	boolean previousMoveWasPawn(String previousMove, int index) {
		String[] splitted = previousMove.split("\\s+");
		int endIndex = Integer.parseInt(splitted[1]);
		int dist = Piece.distance(previousMove);
		if(index==endIndex && dist==2) {
			return true;
		}
		return false;
	}
	
	/**
	 * Implementing the abstract method, getMoveList, from Piece.
	 * @param startIndex. Where the piece initially is located
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @return ArrayList of all indices where the Pawn piece can move
	 */
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		int tempIndex1;
		int tempIndex2;
		int tempIndex3;
		
		if(board[startIndex].piece.firstMove) {
			if(player.equals("w")) {
				if(board[startIndex-16].gridEmpty) {
					if(!Piece.executeMoveKingChecked(board, startIndex, startIndex-16, player)) {
						moveList.add(startIndex-16);
					}
				}
			} else {
				if(board[startIndex+16].gridEmpty) {
					if(!Piece.executeMoveKingChecked(board, startIndex, startIndex+16, player)) {
						moveList.add(startIndex+16);
					}
				}
			}
		}
		
		
		
		
		if(player.equals("w")) {
			tempIndex1 = startIndex - 8; // up
			tempIndex2 = startIndex - 7; // up right
			tempIndex3 = startIndex - 9; // up left
			
			// up
			if(tempIndex1 >= 0 && row-1>=0) {
				if(board[tempIndex1].gridEmpty) {
					moveList.add(tempIndex1);
				}
			}
			
			// up right
			if(tempIndex2 >= 0 && row-1>=0 && col+1<8) {
				if(board[tempIndex2].gridEmpty) {
					if(board[startIndex+1].piece instanceof Pawn && board[startIndex+1].piece.player.equals(enemyPlayer)) {
						String previousMove = Chess.moveHistory.get(Chess.moveHistory.size()-1);
						if(previousMoveWasPawn(previousMove,startIndex+1)) {
							moveList.add(tempIndex2);
						}
					}
				} else {
					if(board[tempIndex2].piece.player.equals(enemyPlayer)) {
						moveList.add(tempIndex2);
					}
				}
			}
			
			// up left
			if(tempIndex3 >= 0 && row-1>=0 && col-1>=0) {
				if(board[tempIndex3].gridEmpty) {
					if(board[startIndex-1].piece instanceof Pawn  && board[startIndex-1].piece.player.equals(enemyPlayer)) {
						String previousMove = Chess.moveHistory.get(Chess.moveHistory.size()-1);
						if(previousMoveWasPawn(previousMove,startIndex-1)) {
							moveList.add(tempIndex3);
						}
					}
				} else {
					if(board[tempIndex3].piece.player.equals(enemyPlayer)) {
						moveList.add(tempIndex3);
					}
				}
			}
			
		} else {
			tempIndex1 = startIndex + 8; // down 
			tempIndex2 = startIndex + 9; // down right
			tempIndex3 = startIndex + 7; // down left
			
			// down
			if(tempIndex1 < 64 && row+1<8) {
				if(board[tempIndex1].gridEmpty) {
					moveList.add(tempIndex1);
				}
			}
			
			// down right
			if(tempIndex2 < 64 && row+1<8 && col+1<8) {
				if(board[tempIndex2].gridEmpty) {
					if(board[startIndex+1].piece instanceof Pawn  && board[startIndex+1].piece.player.equals(enemyPlayer)) {
						String previousMove = Chess.moveHistory.get(Chess.moveHistory.size()-1);
						if(previousMoveWasPawn(previousMove,startIndex+1)) {
							moveList.add(tempIndex2);
						}
					}
				} else {
					if(board[tempIndex2].piece.player.equals(enemyPlayer)) {
						moveList.add(tempIndex2);
					}
				}
			}
			
			// down left
			if(tempIndex3 <64 && row+1<8 && col-1>=0) {
				if(board[tempIndex3].gridEmpty) {
					if(board[startIndex-1].piece instanceof Pawn  && board[startIndex-1].piece.player.equals(enemyPlayer)) {
						String previousMove = Chess.moveHistory.get(Chess.moveHistory.size()-1);
						if(previousMoveWasPawn(previousMove,startIndex-1)) {
							moveList.add(tempIndex3);
						}
					}
				} else {
					if(board[tempIndex3].piece.player.equals(enemyPlayer)) {
						moveList.add(tempIndex3);
					}
				}
			}
			
		}
		return moveList;
	}
	
	/**
	 * Implementing the abstract method, move, from Piece.
	 * @param end. User input to where the move should go
	 * @param player. Which player is the piece
	 * @param board. The chess board
	 * @param moveHistory. An ArrayList of previous moves
	 * @return true, if the move was successfully executed.
	 * @return false, if the move was unsuccessfully executed (illegal move).
	 */
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		if(!board[this.startIndex].piece.player.equals(player)) {
			return false;
		}
		int endIndex = Piece.getIndex(end);
		enpassant = false;
		
		
		ArrayList<Integer> moveList = getMoveList(this.startIndex,player,board);
		
		// Checks if move is en passant
		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		if(player.equals("w")) {
			if((this.startIndex-7==endIndex && row-1>=0 && col+1<8) || (this.startIndex-9==endIndex && row-1>=0 && col-1>=0)) {
				if(board[endIndex].gridEmpty) {
					enpassant = true;
				}
			}
		} else {
			if((this.startIndex+7==endIndex && row+1<8 && col-1>=0) || (this.startIndex+9==endIndex && row+1<8 && col+1<8)) {
				if(board[endIndex].gridEmpty) {
					enpassant = true;
				}
			}
		}
		if(moveList.contains(endIndex)) {
			if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
				Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
				this.firstMove = false;
				if(enpassant) {
					if(player.equals("w")) {
						board[endIndex+8].piece = new Default("null",-1);
						board[endIndex+8].gridEmpty = true;
					} else {
						board[endIndex-8].piece = new Default("null",-1);
						board[endIndex-8].gridEmpty = true;
					}
				}
				if((endIndex>=0 && endIndex<8) || (endIndex>=56 && endIndex<64)) {
					board[endIndex].piece = new Queen(player,endIndex);
				}
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the string format for which the Pawn piece is printed
	 */
	public String toString() {
		return this.player + "p ";
	}
}