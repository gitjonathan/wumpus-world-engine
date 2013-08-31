package board.Square;

import java.util.ArrayList;

import percept.Percept;
import api.WumpusEngineSendable;

public abstract class Square implements WumpusEngineSendable {
	private SquarePosition       position;
	protected ArrayList<Percept> percepts;
	
	public Square(SquarePosition position) {
		this.position = position;
		percepts = new ArrayList<Percept>();
	}
	
	public Square() {
		percepts = new ArrayList<Percept>();
	}
	
	public void setPosition(SquarePosition position) {
		this.position = position;
	}
	
	public ArrayList<Percept> getPercepts() {
		return percepts;
	}
	
	public boolean addPercept(Percept percept) {
		return percepts.add(percept);
	}
	
	public SquarePosition getPosition() {
		return position;
	}
	
	public String toString() {
		String output = "";
		for (Percept percept : percepts) {
			output += percept.toString();
		}
		return output;
	}
	
	abstract public Percept getGeneratedPercept();
}
