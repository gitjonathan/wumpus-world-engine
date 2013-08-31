package board;

import java.util.Random;

import org.codehaus.jettison.json.JSONObject;

import board.Square.GoldSquare;
import board.Square.SquarePosition;
import board.Square.WumpusSquare;

import api.WumpusEngineSendable;

public class Board implements WumpusEngineSendable {

	private Size size;
	private Level[] levels;
	private SquarePosition playerPosition;
	
	public Board(Size size, int numLevels) {
		this.size = size;

		levels = new Level[numLevels];
		int numPits = 0;// TODO(WPH): add pits
		
		for (int levelIndex = 0; levelIndex < numLevels; ++levelIndex) {
			levels[levelIndex] = Level.generateEmptyLevel(levelIndex, size, numPits);
		}
		
		Random randLevel = new Random();
		levels[randLevel.nextInt(numLevels)].addSpecialSquareToLevel(new WumpusSquare());
		levels[randLevel.nextInt(numLevels)].addSpecialSquareToLevel(new GoldSquare());
		
		for (int levelIndex = 0; levelIndex < numLevels; ++levelIndex) {
			levels[levelIndex].generatePercepts();
		}
	}
	
	// returns: true if successful
	public boolean move(SquarePosition moveToPosition) {
		//TODO(WPH)
		
		return false;
	}
	
	public String toString() {
		String output = "";
		
		for (Level level : levels) {
			output += level.toString();
		}
		
		return output;
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
}
