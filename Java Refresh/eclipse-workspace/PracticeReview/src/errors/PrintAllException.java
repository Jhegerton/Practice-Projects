package errors;

@SuppressWarnings("serial")
/**
 * this class defines a recursive error for the printall function
 */
public class PrintAllException extends Exception {
	
	/**
	 * default constructor
	 */
	public PrintAllException() {
		super("Print all was not able to convert to String, Recursion Overflow");
	}
	
	/**
	 * constructor for custom error messages
	 * @param message
	 */
	public PrintAllException(String message) {
		super(message);
	}

}
