package chesspieces;

public class Node {
	String gridColor;
	boolean gridEmpty;
	Piece piece;
	
	public Node(String color, boolean gridEmpty, Piece piece) {
		this.gridColor = color;
		this.gridEmpty = gridEmpty;
	}

	public static Node[][] initialize(Node[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board[i][j] = new Node("W", true, null);
					} else {
						board[i][j] = new Node("B", true, null);
					}
				} else {
					if (j % 2 == 0) {
						board[i][j] = new Node("B", true, null);
					} else {
						board[i][j] = new Node("W", true, null);
					}
				}
				
			}
		}
		
		for (int i = 0; i < 8; i++) {
			board[1][i].piece = new Pawn("b");
			board[1][i].gridEmpty = false;
			board[6][i].piece = new Pawn("w");
			board[6][i].gridEmpty = false;
			board[0][i].gridEmpty = false;
			board[7][i].gridEmpty = false;
		}
		
		board[0][0].piece = new Rook("b");
		board[0][7].piece = new Rook("b");
		board[7][0].piece = new Rook("w");
		board[7][7].piece = new Rook("w");
		
		board[0][1].piece = new Knight("b");
		board[0][6].piece = new Knight("b");
		board[7][1].piece = new Knight("w");
		board[7][6].piece = new Knight("w");
		
		board[0][2].piece = new Bishop("b");
		board[0][5].piece = new Bishop("b");
		board[7][2].piece = new Bishop("w");
		board[7][5].piece = new Bishop("w");
		
		board[0][3].piece = new Queen("b");
		board[7][3].piece = new Queen("w");
		
		board[0][4].piece = new King("b");
		board[7][4].piece = new King("w");
		
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
				} else {
					System.out.print(board[i][j].piece);
				}
			}
			System.out.println((8 - i));
		}
		System.out.print(" a  b  c  d  e  f  g  h");
	}
}