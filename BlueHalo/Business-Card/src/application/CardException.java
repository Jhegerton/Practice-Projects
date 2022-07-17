package application;

/**
 * Exception class for custom exceptions in this program
 */
public class CardException extends Exception{

    /**
     * Exception constructor
     * @param error
     */
    public CardException(String error){
        super(error);
    }
}
