package chess;

/**
 * 
 * @author Andrew Zhou, Bang An
 * 
 */

public class Node {
	String gridColor;
	boolean gridEmpty;

	public Node(String color, boolean gridEmpty) {
		this.gridColor = color;
		this.gridEmpty = gridEmpty;
	}

	public static Node[][] initialize(Node[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board[i][j] = new Node("W", true);
					} else {
						board[i][j] = new Node("B", true);
					}
				} else {
					if (j % 2 == 0) {
						board[i][j] = new Node("B", true);
					} else {
						board[i][j] = new Node("W", true);
					}
				}

			}
		}
		return board;
	}

	public static void print(Node[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].gridEmpty) {
					if (board[i][j].gridColor.equals("W")) {
						System.out.print("   ");
					} else {
						System.out.print("## ");
					}

				}
			}
			System.out.println((8 - i));
		}
		System.out.print(" a  b  c  d  e  f  g  h");
	}
}