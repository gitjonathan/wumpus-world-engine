package board.Square;

import org.codehaus.jettison.json.JSONObject;

import percept.EmptyPercept;
import percept.Percept;

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

	@Override
	public String toString() {
		String output = "E";
		
		output += super.toString();
		
		return output;
	}

	@Override
	public Percept getGeneratedPercept() {
		return new EmptyPercept();
	}

}
