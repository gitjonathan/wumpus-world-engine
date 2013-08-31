package board.Square;

import org.codehaus.jettison.json.JSONObject;

import percept.BreezePercept;
import percept.Percept;
import api.WumpusEngineSendable;

public class PitSquare extends Square implements WumpusEngineSendable {

	public PitSquare() {
		super();
	}
	
	@Override
	public JSONObject toJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Percept getGeneratedPercept() {
		return new BreezePercept();
	}
	
	
	@Override
	public String toString() {
		String output = "P";
		
		output += super.toString();
		
		return output;
	}
}
