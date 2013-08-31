package board.Square;

import org.codehaus.jettison.json.JSONObject;

public class WumpusSquare extends Square {

	public WumpusSquare(SquarePosition position) {
		super(position);
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String output = "W";
		return output;
	}
}
