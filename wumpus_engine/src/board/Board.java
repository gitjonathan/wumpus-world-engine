package board;

import org.codehaus.jettison.json.JSONObject;

import board.Square.SquarePosition;

import api.WumpusEngineSendable;

public class Board implements WumpusEngineSendable {

	private Size size;
	private Level[] levels;
	private SquarePosition playerPosition;
	
	public Board(Size size, int numLevels) {
		this.size = size;

		levels = new Level[numLevels];
		
		for (int levelIndex = 0; levelIndex < numLevels; ++levelIndex) {
			levels[levelIndex] = Level.generateRandomLevel(levelIndex, size);
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
