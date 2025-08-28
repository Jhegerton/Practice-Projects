/// @author Harrison Egerton
/// this package is for defining exceptions
package errors;

/**
 * this class defines an error for a division by zero
 */
public class DivideByZeroException extends RuntimeException {
    /**
     * default constructor
     */
    public DivideByZeroException(){
        super(
                "ERROR: Division by Zero is not possible."
        );
    }

    /**
     * constructor for custom error messages
     * @param message custom error method
     */
    public DivideByZeroException(String message) {
        super(message);
    }
}
