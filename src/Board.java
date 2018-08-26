
public class Board {
	private Square[][] squares;
	private int height;
	private int width;
	private int size;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		this.size = height * width;
		squares = new Square[height][width];
		intiBoard();
	}

	public Square[][] getSquares() {
		return squares;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	private void intiBoard() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				squares[i][j] = new Square();
			}
		}
	}
	
}
