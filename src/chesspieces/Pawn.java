package chesspieces;

import java.util.ArrayList;

import chess.Chess;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Pawn extends Piece {
	public Pawn(String player, int startIndex) {
		super(player,startIndex);
	}
	
	private static boolean enpassant;

	boolean previousMoveWasPawn(String previousMove, int index) {
		String[] splitted = previousMove.split("\\s+");
		int endIndex = Integer.parseInt(splitted[1]);
		int dist = Piece.distance(previousMove);
		/*
		System.out.println("endindex: " + endIndex);
		System.out.println("index: " + index);
		System.out.println("distance: " + dist);
		*/
		if(index==endIndex && dist==2) {
			return true;
		}
		return false;
	}
	
	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);
		
		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		int tempIndex1;
		int tempIndex2;
		int tempIndex3;
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
					if(board[startIndex-1].piece instanceof Pawn  && board[startIndex+1].piece.player.equals(enemyPlayer)) {
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
					if(board[startIndex-1].piece instanceof Pawn  && board[startIndex+1].piece.player.equals(enemyPlayer)) {
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
	
	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		if(!board[this.startIndex].piece.player.equals(player)) {
			return false;
		}
		int endIndex = Piece.getIndex(end);
		enpassant = false;
		
		
		if(this.firstMove) {
			if(player.equals("w")) {
				if(this.startIndex == endIndex+16 && board[endIndex].gridEmpty) {
					if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
						Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
						this.firstMove = false;
						return true;
					}
				}
			} else {
				if(this.startIndex == endIndex-16 && board[endIndex].gridEmpty) {
					if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
						Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
						this.firstMove = false;
						return true;
					}
				}
			}
		}
		
		
		ArrayList<Integer> moveList = getMoveList(this.startIndex,player,board);
		//Piece.RowColPrintList(moveList);
		if(moveList.contains(endIndex)) {
			if(!Piece.executeMoveKingChecked(board, this.startIndex, endIndex, player)) {
				// TODO also check if pawn is promo
				// also need to check if the move is a normal move or an en passant
				Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
				this.firstMove = false;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return this.player + "p ";
	}
}