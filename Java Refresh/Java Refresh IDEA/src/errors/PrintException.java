/// @author Harrison Egerton
/// @package For custom exception classes.
package errors;

/**
 * This class defines a recursive error for the print functions
 */
public class PrintException extends RuntimeException {

	/**
	 * The default constructor.
	 */
	public PrintException() {
        super(
                "Print function was not able to convert to " +
                        "String, Recursion Overflow"
        );
	}
	
	/**
	 * The alternate constructor for custom error messages.
	 * @param message The custom error message.
	 */
	public PrintException(String message) {
        super(message);
	}

}
