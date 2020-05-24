package rpn;
import java.util.Stack;

import rpn.command.OperationC;
import rpn.commandd.NbCommand;

public class MoteurRPN extends Interpreteur {

	private Stack<Double> pile;


	public MoteurRPN() {
		this.pile = new Stack<Double>();
	}

	public String afficher() {
		String s = "[";
		for (Double d : this.pile) {
			s += (d + " ");
		}	
		return s.trim() + "]";
	}

	public int getSize(){
		return this.pile.size();
	}
}
