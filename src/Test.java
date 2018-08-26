import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class Test {
	private GameOfLife game;
	private Board board;

	@Before
	public void setUp() throws Exception {
		board = new Board(10, 10);
		game = new GameOfLife(board);
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void pressAtPositionTen() {
		Board b = new Board(10, 10);
		// b.setSquare(10);
		// game.getBoard().setSquare(10);
		assertEquals(game.getBoard().toString(), b.toString());
	}

	@org.junit.Test
	public void pressAtManyPosition() {
		Board b = new Board(10, 10);
		// b.setSquare(10);
		// b.setSquare(99);
		// b.setSquare(50);
		// b.setSquare(20);
		// game.setSquare(10);
		// game.setSquare(99);
		// game.setSquare(50);
		// game.setSquare(20);
		assertEquals(game.getBoard().toString(), b.toString());
	}

	@org.junit.Test
	public void testOneNeighbourDied() {
		game.setSquare(0, 1);
		game.nextInteration();
		assertEquals(game.getSquaresAt(0, 1).isAlive(), false);
	}

	@org.junit.Test
	public void testTwoNeighboursAlive() {
		game.setSquare(0, 1);
		game.setSquare(1, 1);
		game.setSquare(2, 1);
		game.nextInteration();
		assertEquals(game.getSquaresAt(1, 1).isAlive(), true);
	}

	@org.junit.Test
	public void testFourNeighboursDied() {
		game.setSquare(0, 1);
		game.setSquare(1, 1);
		game.setSquare(2, 1);
		game.setSquare(1, 0);
		game.setSquare(1, 2);
		game.nextInteration();
		assertEquals(game.getSquaresAt(1, 1).isAlive(), false);
	}
	
	@org.junit.Test
	public void testThreeNeighboursBorn() {
		game.setSquare(2, 1);
		game.setSquare(1, 0);
		game.setSquare(1, 2);
		game.nextInteration();
		assertEquals(game.getSquaresAt(1, 1).isAlive(), true);
	}

	@org.junit.Test
	public void testGetBoard() {
		assertEquals(game.getBoard().getHeight(), 10);
		assertEquals(game.getBoard().getWidth(), 10);
	}

}
