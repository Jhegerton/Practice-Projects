package application;

public class CardException extends Exception{
    /**
     * Exception class for custom exceptions in this program
     * @param error
     */
    public CardException(String error){
        super(error);
    }
}
