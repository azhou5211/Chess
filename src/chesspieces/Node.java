package chesspieces;

/**
 * Class that constructs the chess board.
 * Each chess board has an object Node, where node has gridColor, gridEmpty, and Piece
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Node {
	
	/**
	 * The color of chess board location. Either black or white
	 */
	public String gridColor;
	
	/**
	 * The boolean of whether the location on the chess board has a piece or is empty.
	 */
	public boolean gridEmpty;
	
	/**
	 * The piece that is on the board.
	 */
	public Piece piece;

	/**
	 * Creates a new Node, which is one spot on the chess board
	 * @param color. The color of that particular spot
	 * @param gridEmpty. Whether this particular spot is empty or not
	 * @param piece. The piece which this particular spot has. If there is no piece then, it is given default piece.
	 */
	public Node(String color, boolean gridEmpty, Piece piece) {
		this.gridColor = color;
		this.gridEmpty = gridEmpty;
		this.piece = piece;
	}

	/**
	 * This method takes in a Node array of size 64 and initializes all the nodes.
	 * @param board. Given a board array
	 */
	public static void initialize(Node[] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						board[i*8+j] = new Node("W", true, new Default("null",-1));
					} else {
						board[i*8+j] = new Node("B", true, new Default("null",-1));
					}
				} else {
					if (j % 2 == 0) {
						board[i*8+j] = new Node("B", true, new Default("null",-1));
					} else {
						board[i*8+j] = new Node("W", true, new Default("null",-1));
					}
				}

			}
		}
		
		
		for (int i = 0; i < 8; i++) {
			board[1*8+i].piece = new Pawn("b",1*8+i);
			board[1*8+i].gridEmpty = false;
			board[6*8+i].piece = new Pawn("w",6*8+i);
			board[6*8+i].gridEmpty = false;
			board[0*8+i].gridEmpty = false;
			board[7*8+i].gridEmpty = false;
		}
		
		board[0*8+0].piece = new Rook("b",0*8+0);
		board[0*8+7].piece = new Rook("b",0*8+7);
		board[7*8+0].piece = new Rook("w",7*8+0);
		board[7*8+7].piece = new Rook("w",7*8+7);
		
		board[0*8+1].piece = new Knight("b",0*8+1);
		board[0*8+6].piece = new Knight("b",0*8+6);
		board[7*8+1].piece = new Knight("w",7*8+1);
		board[7*8+6].piece = new Knight("w",7*8+6);

		board[0*8+2].piece = new Bishop("b",0*8+2);
		board[0*8+5].piece = new Bishop("b",0*8+5);
		board[7*8+2].piece = new Bishop("w",7*8+2);
		board[7*8+5].piece = new Bishop("w",7*8+5);
		 
		board[0*8+3].piece = new Queen("b",0*8+3);
		board[7*8+3].piece = new Queen("w",7*8+3);
		
		board[0*8+4].piece = new King("b",0*8+4);
		board[7*8+4].piece = new King("w",7*8+4);
	}

	/**
	 * This method is used to print the board in the console.
	 * @param board
	 */
	public static void print(Node[] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i*8+j].gridEmpty) {
					if (board[i*8+j].gridColor.equals("W")) {
						System.out.print("   ");
					} else {
						System.out.print("## ");
					}
				} else {
					System.out.print(board[i*8+j].piece);
				}
			}
			System.out.println((8 - i));
		}
		System.out.println(" a  b  c  d  e  f  g  h");
	}
}