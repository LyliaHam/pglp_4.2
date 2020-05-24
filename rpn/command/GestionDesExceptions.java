package command;
import java.util.Stack;

import rpn.GestionDesExceptions;
import rpn.OperationC;

public class OperationC implements UndoableC {

	private double dernier;
	private double avantDernier;
	private Operation op;
	private Stack<Double> pile;
	
	public OperationC(Stack<Double> pile, Operation ope) {
		ExceptionHandler.handleStackSize(pile.size(), 2);
		this.pile = pile;
		this.operation = operation;
	}

	@Override
	public void application() {
		double res;
		this.dernier = this.pile.pop();
		this.avantDernier = this.pile.pop();
		try {
			result = operation.eval(avantDernier, dernier);
			GestionDesExceptions.handleMinMax(result);
			this.pile.push(result);
		}
		catch (ArithmeticException ex) {
			this.pile.push(avantDernier);
			this.pile.push(dernier);
			throw ex;
		}
	}
	
	@Override
	public void annule() {
		this.pile.pop();
		this.pile.push(avantDernier);
		this.pile.push(dernier);
	}

}
