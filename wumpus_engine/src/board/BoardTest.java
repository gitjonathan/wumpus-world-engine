package board;

import org.junit.Test;


public class BoardTest {
	
	@Test
	public void testMultiply() {
	   Board board = new Board(new Size(10, 10), 2);
	   System.out.println(board.toString());
	 } 
}
