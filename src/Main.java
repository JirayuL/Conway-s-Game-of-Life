
public class Main {

	public static void main(String[] args) {
		Board board = new Board(10, 10);
		GameOfLife game = new GameOfLife(board);
		while(true) {
			game.setSquare(randomSquare(), randomSquare());
			game.setSquare(randomSquare(), randomSquare());
			game.setSquare(randomSquare(), randomSquare());
			game.setSquare(randomSquare(), randomSquare());
			game.printBoard();
			game.nextInteration();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static int randomSquare() {
		return (int) (Math.random() * 10);
	}

}
