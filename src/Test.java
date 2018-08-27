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
		game.setSquare(9, 9);
		assertEquals(game.getSquaresAt(9, 9).isAlive(), true);
	}

	@org.junit.Test
	public void pressAtManyPosition() {
		game.setSquare(0, 0);
		game.setSquare(5, 5);
		game.setSquare(9, 9);
		game.setSquare(2, 2);
		assertEquals(game.getSquaresAt(0, 0).isAlive(), true);
		assertEquals(game.getSquaresAt(5, 5).isAlive(), true);
		assertEquals(game.getSquaresAt(9, 9).isAlive(), true);
		assertEquals(game.getSquaresAt(2, 2).isAlive(), true);
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
