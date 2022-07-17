package application;

/**
 * Interface for the business card parser
 */
public interface BusinessCardParser{
    ContactInfo getContactInfo(String document) throws CardException;

}
