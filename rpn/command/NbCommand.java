package rpn.command;

import java.util.Stack;
import rpn.GestionDesExceptions;

public class NbCommand implements UndoableC {

	private double compteur;
	private Stack<Double> nb;
	
	public NbCommand(Stack<Double> nb, double compteur) {
		this.nb = nb;
		this.compteur = compteur;		
	}
	

	public void application() {
		GestionDesExceptions.gestionMinMax(compteur);
		this.nb.push(compteur);
	}
	
	
	public void annule() {
		this.nb.pop();
	}

}
