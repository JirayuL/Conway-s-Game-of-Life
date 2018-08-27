
public class Main {

	public static void main(String[] args) {
		Board board = new Board(10, 10);
		GameOfLife game = new GameOfLife(board);
		while(true) {
			game.printBoard();
			game.setSquare(randomSquare(), randomSquare());
			game.setSquare(randomSquare(), randomSquare());
			game.setSquare(randomSquare(), randomSquare());
			game.nextInteration();
		}
	}

	private static int randomSquare() {
		return (int) (Math.random() * 10);
	}

}
