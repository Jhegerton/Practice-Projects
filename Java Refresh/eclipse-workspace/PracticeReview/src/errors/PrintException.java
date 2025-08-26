package errors;

@SuppressWarnings("serial")
/**
 * this class defines a recursive error for the printall function
 */
public class PrintException extends Exception {
	
	/**
	 * default constructor
	 */
	public PrintException() {
		super("Print function was not able to convert to String, Recursion Overflow");
	}
	
	/**
	 * constructor for custom error messages
	 * @param message
	 */
	public PrintException(String message) {
		super(message);
	}

}
