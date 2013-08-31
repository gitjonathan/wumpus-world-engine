package board.Square;

import org.codehaus.jettison.json.JSONObject;


import percept.Percept;
import percept.StenchPercept;

public class WumpusSquare extends Square {

	public WumpusSquare(SquarePosition position) {
		super(position);
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Percept getGeneratedPercept() {
		return new StenchPercept();
	}
	
	public String toString() {
		String output = "W";
		
		output += super.toString();
		
		return output;
	}
}
