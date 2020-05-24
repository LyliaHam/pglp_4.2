package rpn;

import rpn.exc.ArgumentPileException;
import rpn.exc.MinMaxException;

public class GestionDesExceptions {
	
	private static final double MIN_VALUE = 100000;
	private static final double MAX_VALUE = 100000;
	
	public static void gestionMinMax(double nb) {
		if(nb > MAX_VALUE || nb < -MIN_VALUE) {
			throw new MinMaxException();
		}
	}
	
	public static void gestionTaillePile (int taille, int tailleExp) {
		if(taille < tailleExp) {
			throw new ArgumentPileException();
		}
	}

}
