package rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rpn.command.Command;
import rpn.command.QuitC;
import rpn.command.AnnuleCommand;
import rpn.command.Annulable;

public class Interpreteur {
	
	private Stack<UndoableCommand> historique;
	private Switch switcher;
	private List<String> log;
	
	public Interpreteur() {
		this.historique = new Stack<UndoableCommand>();
		this.switcher = new Switch();
		this.log = new ArrayList<String>();
	}
	

	private void applicationCommand(Command command) {
		command.application();
	}	
	
	public void applicationStoreCommand(UndoableCommand command) {
		try {
			command.application();
			this.historique.add(command);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void annuleCommand() {
		this.applicationCommand(new AnnuleCommand(historique));
	}
	
	public void log(String str) {
		this.applicationCommand(() -> log.add(str));
	}
	
	public String getLastLog() {
		return log.get(log.size() - 1);
	}
	
	public void shutdown() {
		this.applicationCommand(new QuitCommand(switcher));
	}
	
	public boolean state() {
		return switcher.state();
	}
	
}
