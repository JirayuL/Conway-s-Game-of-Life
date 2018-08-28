
public class Main {

	public static void main(String[] args) {
		Board board = new Board(10, 50);
		GameOfLife game = new GameOfLife(board);
		game.setSquare(5, 10);
		game.setSquare(5, 11);
		game.setSquare(5, 12);
		game.setSquare(5, 13);
		game.setSquare(5, 14);
		game.setSquare(5, 15);
		game.setSquare(5, 16);
		game.setSquare(5, 17);
//		game.setSquare(5, 18);
		
//		game.setSquare(2, 2);
//		game.setSquare(3, 2);
//		game.setSquare(4, 2);
//		game.setSquare(1, 3);
//		game.setSquare(2, 3);
//		game.setSquare(3, 3);
		while(true) {
//			game.setSquare(randomSquare(), randomSquare());
//			game.setSquare(randomSquare(), randomSquare());
//			game.setSquare(randomSquare(), randomSquare());
//			game.setSquare(randomSquare(), randomSquare());
			game.printBoard();
			game.nextInteration();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static int randomSquare() {
		return (int) (Math.random() * 10);
	}

}
