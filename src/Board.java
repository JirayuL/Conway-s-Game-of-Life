
public class Board {
	private Square[][] squares;
	private int height;
	private int width;
	private int size;

	public Board(int width, int height) {
		this.height = height;
		this.width = width;
		this.size = height * width;
		squares = new Square[height][width];
		intiBoard();
	}

	public int getSize() {
		return size;
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

	public void setSquare(int width, int height, boolean alive) {
		squares[width][height].setAlive(alive);
	}

	private void intiBoard() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				squares[i][j] = new Square();
			}
		}
	}

}
