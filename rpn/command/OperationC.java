package rpn.command;

import java.util.Stack;

import rpn.GestionDesExceptions;
import rpn.Operation;

public class OperationC implements Annulable {

	private double dernier;
	private double avantDernier;
	private Operation operation;
	private Stack<Double> pile;
	
	public OperationC (Stack<Double> pile, Operation operation) {
		GestionDesExceptions.gestionTaillePile(pile.size(), 2);
		this.pile = pile;
		this.operation = operation;
	}

	@Override
	public void application() {
		double result;
		this.dernier = this.pile.pop();
		this.avantDernier = this.pile.pop();
		try {
			result = operation.eval(avantDernier, dernier);
			GestionDesExceptions.gestionMinMax(result);
			this.pile.push(result);
		}
		catch (ArithmeticException e) {
			this.pile.push(avantDernier);
			this.pile.push(dernier);
			throw e;
		}
	}
	
	@Override
	public void annule() {
		this.pile.pop();
		this.pile.push(avantDernier);
		this.pile.push(dernier);
	}

}
