package board;

import java.util.Random;

import org.codehaus.jettison.json.JSONObject;

import percept.Percept;

import api.WumpusEngineSendable;
import board.Square.EmptySquare;
import board.Square.PitSquare;
import board.Square.Square;
import board.Square.SquarePosition;

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
	
	public void generatePercepts() {
		for (int x = 0; x < squares.length; ++x) {
			for (int y = 0; y < squares[x].length; ++y) {
				generatePercepts(squares[x][y]);
			}
		}
	}
	
	private void generatePercepts(Square square) {
		SquarePosition position = square.getPosition();
		Percept percept = square.getGeneratedPercept();
		
		if (position.getX() > 0) {
			squares[position.getX() - 1][position.getY()].addPercept(percept);
		}
		
		if (position.getX() < size.getX() - 1) {
			squares[position.getX() + 1][position.getY()].addPercept(percept);
		}
		
		if (position.getY() > 0) {
			squares[position.getX()][position.getY() - 1].addPercept(percept);
		}
		
		if (position.getY() < size.getY() - 1) {
			squares[position.getX()][position.getY() + 1].addPercept(percept);
		}
	}
	
	public void addSpecialSquareToLevel(Square square) {
		Random randX = new Random();
		Random randY = new Random();
		
        SquarePosition position = new SquarePosition(randX.nextInt(size.getY()), randY.nextInt(size.getX()));
		
		while (!(squares[position.getX()][position.getY()] instanceof EmptySquare)) {
			position = new SquarePosition(randX.nextInt(size.getY()), randY.nextInt(size.getX()));	
		}
		
		square.setPosition(position);
        squares[position.getX()][position.getY()] = square;
	}
	
	public static Level generateEmptyLevel(int level, Size size, int numPits) {
		
		Random randX = new Random();
		Random randY = new Random();
		
		Square[][] squares = new Square[size.getY()][size.getX()];
		
		// Initialize board with EmptySquares
		for (int x = 0; x < squares.length; ++x) {
			for (int y = 0; y < squares[x].length; ++y) {
				squares[x][y] = new EmptySquare(new SquarePosition(x, y));
			}
		}
		
		// Initialize board with EmptySquares
		for (int x = 0; x < squares.length; ++x) {
			for (int y = 0; y < squares[x].length; ++y) {
				squares[x][y] = new EmptySquare(new SquarePosition(x, y));
			}
		}		
		
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
		output += "\n";
		output += "\n";
		
		return output;
	}
}
