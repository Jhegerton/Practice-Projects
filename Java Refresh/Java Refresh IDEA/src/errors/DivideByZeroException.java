/// @author Harrison Egerton
/// @package For custom exception classes.
package errors;

/**
 * This class defines an error for a division by zero.
 */
public class DivideByZeroException extends RuntimeException {
    /**
     * The default constructor.
     */
    public DivideByZeroException(){
        super(
                "ERROR: Division by Zero is not possible."
        );
    }

    /**
     * The alternate constructor for custom error messages.
     * @param message The custom error method.
     */
    public DivideByZeroException(String message) {
        super(message);
    }
}
