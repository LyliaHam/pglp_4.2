package rpn;

import java.util.Scanner;

import rpn.exceptions.ArgumentPileException;
import rpn.exceptions.DivisionParZeroException;
import rpn.exceptions.ErreurSaisieException;
import rpn.exceptions.MinMaxException;
import rpn.exceptions.NombreOperationsException;


public class SaisieRPN {

	private MoteurRPN moteur;
	private Scanner s;

	public SaisieRPN(){
		moteur = new MoteurRPN();
	}


	public void setScanner(Scanner s) {
		this.s = s;		
	}

	public void closeScanner() {
		s.close();
	}

	public void saisie() {
		this.setScanner(new Scanner(System.in));

		String input = ""; 
		String str = "";

		while(moteur.isOn()) {
			System.out.println("Saisir un entier, une opération ou exit pour sortir, puis taper sur entrée");
			try {
				input = scanneLigne();
				str += input + " ";
				System.out.println(str);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(moteur.afficherPile());
		}

		System.out.println("Fin du programme");
		this.closeScanner();    
	}

	public String scanneLigne() throws DivisionParZeroException, MinMaxException, 
	ArgumentPileException, ErreurSaisieException {
		String input;
		if (s.hasNextDouble()) {
			Double d = sc.nextDouble();
			moteur.enregistrerNb(d);
			s.nextLine();
			input = d.toString();
		} 
		else {
			input = s.nextLine();
			if (input.equals("exit")) {
				moteur.shutdown();
			}
			else if (input.equals("undo")) {
				moteur.undoCommand();
			}
			else if (isOperation(input)) {
				moteur.appliquerOperation(renvoieOperation(input));	
			}
			else {
				throw new ErreurSaisieException();
			}
		}
		return input;
	}

	private Operation renvoieOperation(String str) {
		for (Operation op : Operation.values())
			if (str.equals(op.getSymbole()))
				return op;
		return null;
	}

	public void isStackValid() throws NombreOperationsException {
		if (!(this.moteur.getSizePile() == 1)) {throw new NombreOperationsException();}
	}
	

	private void checkNombreOperations() {
		try {
			this.isStackValid();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


}
