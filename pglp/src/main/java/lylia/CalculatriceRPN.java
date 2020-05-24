package rpn;


public enum CalculatriceRPN{
	En;
	
	public void run( String[] args) {
		SaisieRPN saisie = new SaisieRPN();
		saisie.saisie();
	}
	
	public static void main( String[] args ) {
		En.run(args);
		
	}
}
