package board;

import java.util.Random;

import org.codehaus.jettison.json.JSONObject;

import api.WumpusEngineSendable;
import board.Square.EmptySquare;
import board.Square.GoldSquare;
import board.Square.Square;
import board.Square.SquarePosition;
import board.Square.WumpusSquare;

public class Level implements WumpusEngineSendable{
	private int level;
	private Size size;
	private Square[][] squares;
	
	private Level(int level, Size size, Square[][] squares) {
		this.level   = level;
		this.size    = size;
		this.squares = squares;
	}
	
	public int getLevel() {
		return level;
	}

	public Size getSize() {
		return size;
	}
	
	public Square getSquare(SquarePosition position) {
		assert(position.getX() < squares[0].length);
		assert(position.getY() < squares.length);
		
		return squares[position.getX()][position.getY()];
	}
	
	public static Level generateRandomLevel(int level, Size size) {
		//TODO(WPH): build random squares (following rules in book)
		//TODO(WPH):
		
		Random randX = new Random();
		Random randY = new Random();
		
		Square[][] squares = new Square[size.getDepth()][size.getWidth()];
		
		// Initialize board with EmptySquares
		for (int x = 0; x < squares.length; ++x) {
			for (int y = 0; y < squares[x].length; ++y) {
				squares[x][y] = new EmptySquare(new SquarePosition(x, y));
			}
		}
		
		// Place Special Squares
		SquarePosition wumpusPosition = new SquarePosition(randX.nextInt(size.getDepth()), randY.nextInt(size.getWidth()));
        squares[wumpusPosition.getX()][wumpusPosition.getY()] = new WumpusSquare(wumpusPosition);
		
		SquarePosition goldPosition   = new SquarePosition(randX.nextInt(size.getDepth()), randY.nextInt(size.getWidth()));
		while (goldPosition == wumpusPosition) {
			goldPosition   = new SquarePosition(randX.nextInt(size.getDepth()), randY.nextInt(size.getWidth()));	
		}
		squares[goldPosition.getX()][goldPosition.getY()] = new GoldSquare(wumpusPosition);

		Level randomLevel = new Level(level, size, squares);
		
		return randomLevel;
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String output = "Level: " + level + "\n";
		String delimiter = "---------------------------------------";
		
		for (int x = 0; x < squares.length; ++x) {
			output += "\n";
			output += delimiter;
			output += "\n";
			for (int y = 0; y < squares[x].length; ++y) {
				output += squares[x][y].toString() + " | ";
			}
		}
		output += "\n";
		output += delimiter;
		
		return output;
	}
}
