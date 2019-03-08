package chesspieces;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class King extends Piece {
	public King(String player, int startIndex) {
		super(player, startIndex);
	}

	public static boolean isPositionChecked(Node[] board, int kingIndex, String player) {
		String enemyPlayer = Piece.getEnemyPlayer(player);

		int tempIndex2 = kingIndex - 9; // up left
		int tempIndex4 = kingIndex - 7; // up right
		int tempIndex6 = kingIndex + 9; // down right
		int tempIndex8 = kingIndex + 7; // down left

		int knightIndex1 = kingIndex - 10; // left up
		int knightIndex2 = kingIndex - 17; // up left
		int knightIndex3 = kingIndex - 15; // up right
		int knightIndex4 = kingIndex - 6; // right up
		int knightIndex5 = kingIndex + 10; // right down
		int knightIndex6 = kingIndex + 17; // down right
		int knightIndex7 = kingIndex + 15; // down left
		int knightIndex8 = kingIndex + 6; // left down

		// Going up
		int row = (int) Math.floor(kingIndex / 8);
		int col = kingIndex%8;
		for (int i = row-1; i >= 0; i--) {
			if (!board[i*8+col].gridEmpty) {
				if (board[i*8+col].piece.player.equals(enemyPlayer) && (board[i*8+col].piece instanceof Rook
						|| board[i*8+col].piece instanceof Queen)) {
					return true;
				}
				break;
			}
		}

		// Going down
		for (int i = row+1; i < 8; i++) {
			if (!board[i*8+col].gridEmpty) {
				if (board[i*8+col].piece.player.equals(enemyPlayer) && (board[i*8+col].piece instanceof Rook
						|| board[i*8+col].piece instanceof Queen)) {
					return true;
				}
				break;
			}
		}

		// Going left
		row = (int) Math.floor(kingIndex / 8);
		for (int i = kingIndex - 1; i >= row * 8; i--) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Rook
						|| board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
		}

		// Going right
		//row++;
		for (int i = kingIndex + 1; i < (row+1) * 8; i++) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Rook
						|| board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
		}

		// Going up left
		int i = kingIndex - 9;
		col = (kingIndex % 8) - 1;
		while (col >= 0 && i >= 0) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Bishop || board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
			i -= 9;
			col--;
		}

		// Going down right
		i = kingIndex + 9;
		col = (kingIndex % 8) + 1;
		while (col < 8 && i < 64) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Bishop || board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
			i += 9;
			col++;
		}

		// Going up right
		i = kingIndex - 7;
		col = (kingIndex % 8) + 1;
		while (col < 8 && i >= 0) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Bishop || board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
			i -= 7;
			col++;
		}

		// Going down left
		i = kingIndex + 7;
		col = (kingIndex % 8) - 1;
		while (col >= 0 && i < 64) {
			if (!board[i].gridEmpty) {
				if (board[i].piece.player.equals(enemyPlayer) && (board[i].piece instanceof Bishop || board[i].piece instanceof Queen)) {
					return true;
				}
				break;
			}
			i += 7;
			col--;
		}
		
		row = (int) Math.floor(kingIndex/8);
		col = kingIndex%8;
		if (knightIndex1 >= 0 && row-1>=0 && col-2>=0) {
			if (board[knightIndex1].piece.player.equals(enemyPlayer)
					&& board[knightIndex1].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex2 >= 0 && row-2>=0 && col-1>=0) {
			if (board[knightIndex2].piece.player.equals(enemyPlayer)
					&& board[knightIndex2].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex3 >= 0  && row-2>=0 && col+1<8) {
			if (board[knightIndex3].piece.player.equals(enemyPlayer)
					&& board[knightIndex3].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex4 >= 0 && row-1>=0 && col+2<8) {
			if (board[knightIndex4].piece.player.equals(enemyPlayer)
					&& board[knightIndex4].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex5 < 64 && row+1<8 && col+2<8) {
			if (board[knightIndex5].piece.player.equals(enemyPlayer)
					&& board[knightIndex5].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex6 < 64 && row+2<8 && col+1<8) {
			if (board[knightIndex6].piece.player.equals(enemyPlayer)
					&& board[knightIndex6].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex7 < 64 && row+2<8 && col-1>=0) {
			if (board[knightIndex7].piece.player.equals(enemyPlayer)
					&& board[knightIndex7].piece instanceof Knight) {
				return true;
			}
		}

		if (knightIndex8 < 64 && row+1<8 && col-2>=0) {
			if (board[knightIndex8].piece.player.equals(enemyPlayer)
					&& board[knightIndex8].piece instanceof Knight) {
				return true;
			}
		}

		if (player.equals("w")) {
			// White king
			// pawn attacks at up left and up right
			// up left
			if (tempIndex2 >= 0 && row-1>=0 && col-1>=0) {
				if (board[tempIndex2].piece.player.equals(enemyPlayer)
						&& board[tempIndex2].piece instanceof Pawn) {
					return true;
				}
			}

			// up right
			if (tempIndex4 >= 0 && row-1>=0 && col+1<8) {
				if (board[tempIndex4].piece.player.equals(enemyPlayer)
						&& board[tempIndex4].piece instanceof Pawn) {
					return true;
				}
			}
		} else {
			// Black King
			// pawn attacks down left and down right
			// down right
			if (tempIndex6 < 64 && row+1<8 && col+1<8) {
				if (board[tempIndex6].piece.player.equals(enemyPlayer)
						&& board[tempIndex6].piece instanceof Pawn) {
					return true;
				}
			}

			// down left
			if (tempIndex8 < 64 && row+1<8 && col-1>=0) {
				if (board[tempIndex8].piece.player.equals(enemyPlayer)
						&& board[tempIndex8].piece instanceof Pawn) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		String enemyPlayer = Piece.getEnemyPlayer(player);

		int row = (int) Math.floor(startIndex/8);
		int col = startIndex%8;
		int tempIndex1 = startIndex - 1; // left
		int tempIndex2 = startIndex - 9; // up left
		int tempIndex3 = startIndex - 8; // up
		int tempIndex4 = startIndex - 7; // up right
		int tempIndex5 = startIndex + 1; // right
		int tempIndex6 = startIndex + 9; // down right
		int tempIndex7 = startIndex + 8; // down
		int tempIndex8 = startIndex + 7; // down left

		if (tempIndex1 >= 0 && col-1>=0) {
			if (board[tempIndex1].gridEmpty) {
				if (!isPositionChecked(board, tempIndex1, player)) {
					moveList.add(tempIndex1);
				}
			} else {
				if (board[tempIndex1].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex1, player)) {
						moveList.add(tempIndex1);
					}
				}
			}
		}

		if (tempIndex2 >= 0 && row-1>=0 && col-1>=0) {
			if (board[tempIndex2].gridEmpty) {
				if (!isPositionChecked(board, tempIndex2, player)) {
					moveList.add(tempIndex2);
				}
			} else {
				if (board[tempIndex2].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex2, player)) {
						moveList.add(tempIndex2);
					}
				}
			}
		}

		if (tempIndex3 >= 0 && row-1>=0) {
			if (board[tempIndex3].gridEmpty) {
				if (!isPositionChecked(board, tempIndex3, player)) {
					moveList.add(tempIndex3);
				}
			} else {
				if (board[tempIndex3].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex3, player)) {
						moveList.add(tempIndex3);
					}
				}
			}
		}

		if (tempIndex4 >= 0 && row-1>=0 && col+1<8) {
			if (board[tempIndex4].gridEmpty) {
				if (!isPositionChecked(board, tempIndex4, player)) {
					moveList.add(tempIndex4);
				}
			} else {
				if (board[tempIndex4].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex4, player)) {
						moveList.add(tempIndex4);
					}
				}
			}
		}

		if (tempIndex5 < 64 && col+1<8) {
			if (board[tempIndex5].gridEmpty) {
				if (!isPositionChecked(board, tempIndex5, player)) {
					moveList.add(tempIndex5);
				}
			} else {
				if (board[tempIndex5].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex5, player)) {
						moveList.add(tempIndex5);
					}
				}
			}
		}

		if (tempIndex6 < 64 && row+1<8 && col+1<8) {
			if (board[tempIndex6].gridEmpty) {
				if (!isPositionChecked(board, tempIndex6, player)) {
					moveList.add(tempIndex6);
				}
			} else {
				if (board[tempIndex6].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex6, player)) {
						moveList.add(tempIndex6);
					}
				}
			}
		}

		if (tempIndex7 < 64 && row+1<8) {
			if (board[tempIndex7].gridEmpty) {
				if (!isPositionChecked(board, tempIndex7, player)) {
					moveList.add(tempIndex7);
				}
			} else {
				if (board[tempIndex7].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex7, player)) {
						moveList.add(tempIndex7);
					}
				}
			}
		}

		if (tempIndex8 < 64 && row+1<8 && col-1>=0) {
			if (board[tempIndex8].gridEmpty) {
				if (!isPositionChecked(board, tempIndex8, player)) {
					moveList.add(tempIndex8);
				}
			} else {
				if (board[tempIndex8].piece.player.equals(enemyPlayer)) {
					if (!isPositionChecked(board, tempIndex8, player)) {
						moveList.add(tempIndex8);
					}
				}
			}
		}
		return moveList;
	}

	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		if (!board[this.startIndex].piece.player.equals(player)) {
			return false;
		}
		int endIndex = Piece.getIndex(end);

		/**
		 * Castling Rules Your king has been moved earlier in the game. The rook that
		 * you would castle with has been moved earlier in the game. There are pieces
		 * standing between your king and rook. The king is in check. The king moves
		 * through a square that is attacked by a piece of the opponent. The king would
		 * be in check after castling.
		 */
		if (this.firstMove) {
			if (player.equals("w")) {
				if (endIndex == 58) {
					// Castle to the left
					if (board[56].piece.firstMove && board[56].piece instanceof Rook) {
						if (board[57].gridEmpty && board[58].gridEmpty && board[59].gridEmpty) {
							if (!isPositionChecked(board, 60, "w")
									&& !isPositionChecked(board, 58, "w")
									&& !isPositionChecked(board, 59, "w")) {
								board[56].piece.firstMove = false;
								this.firstMove = false;
								Piece.executeMove(board, this.startIndex, endIndex,
										moveHistory);
								Piece.executeMove(board, 56, 59, moveHistory);
								return true;
							}
						}
					}
					return false;
				} else if (endIndex == 62) {
					// Castle to the right
					if (board[63].piece.firstMove && board[63].piece instanceof Rook) {
						if (board[61].gridEmpty && board[62].gridEmpty) {
							if (!isPositionChecked(board, 60, "w")
									&& !isPositionChecked(board, 61, "w")
									&& !isPositionChecked(board, 62, "w")) {
								board[63].piece.firstMove = false;
								this.firstMove = false;
								Piece.executeMove(board, this.startIndex, endIndex,
										moveHistory);
								Piece.executeMove(board, 63, 61, moveHistory);
								return true;
							}
						}
					}
					return false;
				}
			} else {
				if (endIndex == 2) {
					// Castle to the left
					if (board[0].piece.firstMove && board[0].piece instanceof Rook) {
						if (board[1].gridEmpty && board[2].gridEmpty && board[3].gridEmpty) {
							if (!isPositionChecked(board, 2, "b")
									&& !isPositionChecked(board, 3, "b")
									&& !isPositionChecked(board, 4, "b")) {
								board[0].piece.firstMove = false;
								this.firstMove = false;
								Piece.executeMove(board, this.startIndex, endIndex,
										moveHistory);
								Piece.executeMove(board, 0, 3, moveHistory);
								return true;
							}
						}
					}
					return false;
				} else if (endIndex == 6) {
					// Castle to the right
					if (board[7].piece.firstMove && board[7].piece instanceof Rook) {
						if (board[5].gridEmpty && board[6].gridEmpty) {
							if (!isPositionChecked(board, 4, "b")
									&& !isPositionChecked(board, 5, "b")
									&& !isPositionChecked(board, 6, "b")) {
								board[7].piece.firstMove = false;
								this.firstMove = false;
								Piece.executeMove(board, this.startIndex, endIndex,
										moveHistory);
								Piece.executeMove(board, 7, 5, moveHistory);
								return true;
							}
						}
					}
					return false;
				}
			}
		}
		
		ArrayList<Integer> moveList = getMoveList(this.startIndex,player,board);
		//Piece.RowColPrintList(moveList);
		if(moveList.contains(endIndex)) {
			Piece.executeMove(board, this.startIndex, endIndex, moveHistory);
			this.firstMove = false;
			return true;
		}
		return false;
	}

	public String toString() {
		return this.player + "K ";
	}
}