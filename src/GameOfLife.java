
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
		if (this.getSquaresAt(width, height).isAlive()) {			
			board.setSquare(width, height, false);
		} else {
			board.setSquare(width, height, true);
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				System.out.print(board.getSquares()[i][j].getNeighbor() + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------");
	}

	private void countNeighbor() {
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				int neighbor = 0;
				Square s = this.getSquaresAt(i, j);
				if (isLeftMost(i) && isTopMost(j)) {
					neighbor = checkRight(i, j, neighbor);
					neighbor = checkBelow(i, j, neighbor);
					neighbor = checkBelowRight(i, j, neighbor);
				} else if (isRightMost(i) && isTopMost(j)) {
					neighbor = checkLeft(i, j, neighbor);
					neighbor = checkBelowLeft(i, j, neighbor);
					neighbor = checkBelow(i, j, neighbor);
				} else if (isTopMost(j)) {
					neighbor = checkRight(i, j, neighbor);
					neighbor = checkLeft(i, j, neighbor);
					neighbor = checkBelow(i, j, neighbor);
					neighbor = checkBelowLeft(i, j, neighbor);
					neighbor = checkBelowRight(i, j, neighbor);
				} else if (isLeftMost(i) && isBelowMost(j)) {
					neighbor = checkAbove(i, j, neighbor);
					neighbor = checkAboveRight(i, j, neighbor);
					neighbor = checkRight(i, j, neighbor);
				} else if (isRightMost(i) && isBelowMost(j)) {
					neighbor = checkAbove(i, j, neighbor);
					neighbor = checkAboveLeft(i, j, neighbor);
					neighbor = checkLeft(i, j, neighbor);
				} else if (isBelowMost(j)) {
					neighbor = checkLeft(i, j, neighbor);
					neighbor = checkAboveLeft(i, j, neighbor);
					neighbor = checkAbove(i, j, neighbor);
					neighbor = checkAboveRight(i, j, neighbor);
					neighbor = checkRight(i, j, neighbor);
				} else if (isLeftMost(i)) {
					neighbor = checkAbove(i, j, neighbor);
					neighbor = checkAboveRight(i, j, neighbor);
					neighbor = checkRight(i, j, neighbor);
					neighbor = checkBelowRight(i, j, neighbor);
					neighbor = checkBelow(i, j, neighbor);
				} else if (isRightMost(i)) {
					neighbor = checkAbove(i, j, neighbor);
					neighbor = checkAboveLeft(i, j, neighbor);
					neighbor = checkLeft(i, j, neighbor);
					neighbor = checkBelowLeft(i, j, neighbor);
					neighbor = checkBelow(i, j, neighbor);
				} else {
					neighbor = checkAllDirection(i, j, neighbor);
				}
				s.setNeighbor(neighbor);
			}
		}
	}

	public int checkAllDirection(int i, int j, int neighbor) {
		if (this.getSquaresAt(i - 1, j - 1).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i, j - 1).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i + 1, j - 1).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i - 1, j).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i + 1, j).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i - 1, j + 1).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i, j + 1).isAlive()) {
			neighbor++;
		}
		if (this.getSquaresAt(i + 1, j + 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkAboveLeft(int i, int j, int neighbor) {
		if (this.getSquaresAt(i - 1, j - 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkAboveRight(int i, int j, int neighbor) {
		if (this.getSquaresAt(i + 1, j - 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkAbove(int i, int j, int neighbor) {
		if (this.getSquaresAt(i, j - 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public boolean isBelowMost(int j) {
		return j + 1 >= board.getHeight();
	}

	public int checkBelowLeft(int i, int j, int neighbor) {
		if (this.getSquaresAt(i - 1, j + 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkLeft(int i, int j, int neighbor) {
		if (this.getSquaresAt(i - 1, j).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkBelowRight(int i, int j, int neighbor) {
		if (this.getSquaresAt(i + 1, j + 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkBelow(int i, int j, int neighbor) {
		if (this.getSquaresAt(i, j + 1).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public int checkRight(int i, int j, int neighbor) {
		if (this.getSquaresAt(i + 1, j).isAlive()) {
			neighbor++;
		}
		return neighbor;
	}

	public boolean isRightMost(int i) {
		return i + 1 >= board.getWidth();
	}

	public boolean isTopMost(int j) {
		return j - 1 < 0;
	}

	public boolean isLeftMost(int i) {
		return isTopMost(i);
	}

	public void nextInteration() {
		countNeighbor();
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				Square s = this.getSquaresAt(j, i);
				if (s.isAlive() && (s.getNeighbor() < 2 || s.getNeighbor() > 3))
					s.setAlive(false);
				if (s.isAlive() == false && s.getNeighbor() == 3)
					s.setAlive(true);
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
