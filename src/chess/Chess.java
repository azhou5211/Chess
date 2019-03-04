package chess;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

import chess.Node;

public class Chess {

	public static void main(String[] args) {
		Node[][] board = new Node[8][8];
		Node.initialize(board);
		Node.print(board);

	}

}
