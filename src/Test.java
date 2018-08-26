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
//		b.setSquare(10);
//		game.getBoard().setSquare(10);
		assertEquals(game.getBoard().toString(), b.toString());
	}
	
	@org.junit.Test
	public void pressAtManyPosition() {
		Board b = new Board(10, 10);
//		b.setSquare(10);
//		b.setSquare(99);
//		b.setSquare(50);
//		b.setSquare(20);
//		game.setSquare(10);
//		game.setSquare(99);
//		game.setSquare(50);
//		game.setSquare(20);
		assertEquals(game.getBoard().toString(), b.toString());
	}
	
//	@org.junit.Test
//	public void nextIteration() {
//		game.setSquare(12);
//		game.nextInteration();
//		assertEquals(game.getSquaresAt(12).isAlive(), false);
//	}
	
	@org.junit.Test
	public void twoNeighborSurvine() {
//		game.setSquare(11);
//		game.setSquare(12);
//		game.setSquare(13);
		game.printTable();
		game.nextInteration();
		game.printTable();
//		assertEquals(game.getSquaresAt(11).isAlive(), false);
//		assertEquals(game.getSquaresAt(12).isAlive(), true);
//		assertEquals(game.getSquaresAt(13).isAlive(), false);
	}
	

}
