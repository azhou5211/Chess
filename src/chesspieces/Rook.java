package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Rook extends Piece {

	boolean firstMove;

	public Rook(String player, int row, int col) {
		super(player, row, col);
		this.firstMove = true;
	}

	@Override
	public boolean move(String end, String player, Node[][] board) {
		int row = this.row;
		int col = this.col;
		int[] endIndex = Piece.getIndex(end);
		boolean checkEndIndex = false;
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;

		// Check left
		for (int j = col - 1; j >= 0; j--) {
			if (row == endIndex[0] && j == endIndex[1]) {
				checkEndIndex = true;
				left = true;
			}
		}

		// Check right
		for (int j = col + 1; j < 8; j++) {
			if (row == endIndex[0] && j == endIndex[1]) {
				checkEndIndex = true;
				right = true;
			}
		}

		// Check down
		for (int i = row + 1; i < 8; i++) {
			if (i == endIndex[0] && col == endIndex[1]) {
				checkEndIndex = true;
				down = true;
			}
		}

		// Check up
		for (int i = row - 1; i >= 0; i--) {
			if (i == endIndex[0] && col == endIndex[1]) {
				checkEndIndex = true;
				up = true;
			}
		}

		if (checkEndIndex) {
			if (board[this.row][this.col].piece.player.equals(player)) {
				if (up) {
					for (int i = row - 1; i > endIndex[0]; i--) {
						if (!board[i][this.col].gridEmpty) {
							return false;
						}
					}
					if (board[endIndex[0]][endIndex[1]].gridEmpty) {
						Piece.executeMove(board, endIndex, this.row, this.col);
						return true;
					} else {
						String enemyPlayer = Piece.getEnemyPlayer(player);
						if (board[endIndex[0]][endIndex[1]].piece.player.equals(enemyPlayer)) {
							Piece.executeMove(board, endIndex, this.row, this.col);
							return true;
						}
					}
				} else if (down) {
					for (int i = row + 1; i < endIndex[0]; i++) {
						if (!board[i][this.col].gridEmpty) {
							return false;
						}
					}
					if (board[endIndex[0]][endIndex[1]].gridEmpty) {
						Piece.executeMove(board, endIndex, this.row, this.col);
						return true;
					} else {
						String enemyPlayer = Piece.getEnemyPlayer(player);
						if (board[endIndex[0]][endIndex[1]].piece.player.equals(enemyPlayer)) {
							Piece.executeMove(board, endIndex, this.row, this.col);
							return true;
						}
					}
				} else if (left) {
					for (int j = col - 1; j > endIndex[1]; j--) {
						if (!board[this.row][j].gridEmpty) {
							return false;
						}
					}
					if (board[endIndex[0]][endIndex[1]].gridEmpty) {
						Piece.executeMove(board, endIndex, this.row, this.col);
						return true;
					} else {
						String enemyPlayer = Piece.getEnemyPlayer(player);
						if (board[endIndex[0]][endIndex[1]].piece.player.equals(enemyPlayer)) {
							Piece.executeMove(board, endIndex, this.row, this.col);
							return true;
						}
					}
				} else if(right){
					for (int j = col + 1; j < endIndex[1]; j++) {
						if (!board[this.row][j].gridEmpty) {
							return false;
						}
					}
					if (board[endIndex[0]][endIndex[1]].gridEmpty) {
						Piece.executeMove(board, endIndex, this.row, this.col);
						return true;
					} else {
						String enemyPlayer = Piece.getEnemyPlayer(player);
						if (board[endIndex[0]][endIndex[1]].piece.player.equals(enemyPlayer)) {
							Piece.executeMove(board, endIndex, this.row, this.col);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public String toString() {
		return this.player + "R ";
	}
}