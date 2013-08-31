package board.Square;

import org.codehaus.jettison.json.JSONObject;

import api.WumpusEngineSendable;

public class GoldSquare extends Square implements WumpusEngineSendable {

	public GoldSquare(SquarePosition position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String output = "G";
		return output;
	}
}
