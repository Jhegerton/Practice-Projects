package errors;

@SuppressWarnings("serial")
/**
 * this class defines a recursive error for the print functions
 */
public class PrintException extends RuntimeException {

	/**
	 * default constructor
	 */
	public PrintException() {
        super(
                "Print function was not able to convert to " +
                        "String, Recursion Overflow"
        );
	}
	
	/**
	 * constructor for custom error messages
	 * @param message custom error method
	 */
	public PrintException(String message) {
        super(message);
	}

}
