package board.Square;

import org.codehaus.jettison.json.JSONObject;

import percept.GlitterPercept;
import percept.Percept;

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
	
	@Override
	public Percept getGeneratedPercept() {
		return new GlitterPercept();
	}
	
	@Override
	public String toString() {
		String output = "G";
		
		output += super.toString();
		
		return output;
	}
}
