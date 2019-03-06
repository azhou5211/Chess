package chesspieces;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Knight extends Piece {

	public Knight(String player, int row, int col) {
		super(player, row, col);
	}

	@Override
	public boolean move(String end, String player, Node[][] board) {
		int row = this.row;
		int col = this.col;
		int[] endIndex = Piece.getIndex(end);
		boolean checkEndIndex = false;

		// Up 2 and left 1
		if (row + 2 == endIndex[0] && col - 1 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Up 2 and right 1
		if (row + 2 == endIndex[0] && col + 1 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// right 2 and up 1
		if (row + 1 == endIndex[0] && col + 2 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Right 2 and down 1
		if (row - 1 == endIndex[0] && col + 2 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Down 2 and left 1
		if (row - 2 == endIndex[0] && col - 1 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Down 2 and right 1
		if (row - 2 == endIndex[0] && col + 1 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Left 2 and up 1
		if (row + 1 == endIndex[0] && col - 2 == endIndex[1]) {
			checkEndIndex = true;
		} else
		// Left 2 and down 1
		if (row - 1 == endIndex[0] && col - 2 == endIndex[1]) {
			checkEndIndex = true;
		}

		if (checkEndIndex) {
			if (board[this.row][this.col].piece.player.equals(player)) {
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

		return false;
	}

	public String toString() {
		return this.player + "N ";
	}
}