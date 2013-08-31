import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JettisonJSONHelloWorld {

	private String title = "Hello JSON!";

	public JettisonJSONHelloWorld() {
	}
	
	public JettisonJSONHelloWorld(String title) {
		this.title = title;
	}
	
	public JSONObject toJSON() throws JSONException {
		//TODO(WPH): Probably should have things like the "from" fields in a parent class
		JSONObject json = new JSONObject();
		json.put("from", "Engine");
		json.put("type", "JettisonJSONHelloWorld");
		json.put("title", title);
		return json;
	}
	
	public void fromJSON(JSONObject json) throws JSONException {
		if (json.has("title")) {
			title = json.getString("title");
		} else {
			throw new JSONException("JettisonJSONHelloWorld: Does not contain all fields needed.");
		}
	}
	
	public String toString() {
		return title;
	}
}
