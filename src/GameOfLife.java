
public class GameOfLife {
	private Board board;

	public GameOfLife(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	// public List<Square> getSquares() {
	// return board.getSquares();
	// }
	//
	public Square getSquaresAt(int width, int height) {
		Square[][] s = board.getSquares();
		return s[width][height];
	}

	public void setSquare(int width, int height) {
		board.setSquare(width, height);
	}

	public void printTable() {
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				System.out.print(board.getSquares()[i][j].getNeighbor() + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------");
	}

	public void nextInteration() {
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				Square s = this.getSquaresAt(j, i);
				if (s.isAlive() && (s.getNeighbor() < 2 || s.getNeighbor() > 3))
					s.setAlive();
				if (s.isAlive() == false && s.getNeighbor() == 3)
					s.setAlive();
			}
		}
		// System.out.println(this.board.countNeighbor(11));
		// System.out.println(this.board.countNeighbor(12));
		// System.out.println(this.board.countNeighbor(13));
		// for (int i = 0; i < board.getSize(); i++) {
		// System.out.println(this.board.countNeighbor(i));
		// if (this.getSquares().get(i).isAlive() && (this.board.countNeighbor(i) < 2 ||
		// this.board.countNeighbor(i) > 3)) {
		// this.getSquares().get(i).setAlive(false);
		// System.out.println(this.getSquares().get(i).getNeighbor());
		//// System.out.println("inif");
		// }
		// }
	}

}
