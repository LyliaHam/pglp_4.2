package rpn.command;

import java.util.Stack;

import rpn.GestionDesExceptions;

public class AnnuleCommand implements Command {
	
	private Annulable lastCommand;
	
	public annuleCommand (Stack<Annulable> historique) {
		GestionDesExceptions.gestionTaillePile(historique.size(), 1);
		this.lastCommand = historique.pop();
	}

	@Override
	public void application() {
		lastCommand.annule();		
	}
}
