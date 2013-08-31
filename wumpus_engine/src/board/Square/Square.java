package board.Square;

import java.util.ArrayList;

import percept.Percept;
import api.WumpusEngineSendable;

public abstract class Square implements WumpusEngineSendable {
	private SquarePosition     position;
	private ArrayList<Percept> percepts;
	
	public Square(SquarePosition position) {
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
}
