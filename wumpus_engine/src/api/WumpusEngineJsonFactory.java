package api;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import board.Board;

public abstract class WumpusEngineJsonFactory {
	
	private static final WumpusEngineJsonFactory NULL = null;
	public WumpusEngineJsonFactory(JSONObject json) {
	}

//	public WumpusEngineJsonFactory createObject(JSONObject json) throws JSONException {
//		WumpusEngineJsonFactory createdObject;
//		if (json.getString("type").compareTo("Board") == 0) {
////			createdObject = new Board(json);
////		} else if (json.getString("type").compareTo("Square") == 0) {
////			createdObject = new Square();
//		} else {
//			createdObject = NULL;
//		}
//		
//		return createdObject;
//	}
	
	abstract public void fromJSON(JSONObject json);
}
