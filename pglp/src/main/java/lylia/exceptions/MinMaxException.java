package rpn.exceptions;

public class MinMaxException extends ArithmeticException {

	public MinMaxException() {
		super("Valeur trop grande ou trop petite");
	}
}
