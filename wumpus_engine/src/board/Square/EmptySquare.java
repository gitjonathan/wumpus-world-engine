package board.Square;

import org.codehaus.jettison.json.JSONObject;

import api.WumpusEngineSendable;

public class EmptySquare extends Square implements WumpusEngineSendable {

	public EmptySquare(SquarePosition position) {
		super(position);
	}

	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String output = "E";
		return output;
	}

}
