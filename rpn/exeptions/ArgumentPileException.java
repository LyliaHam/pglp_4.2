package rpn.exceptions;

public class ArgumentPileException extends IllegalArgumentException {

	public ArgumentPileException() {
		super("Pas assez d'éléments ");
	}
}
