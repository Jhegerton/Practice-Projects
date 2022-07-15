package application;

public interface BusinessCardParser{
    ContactInfo getContactInfo(String document) throws CardException;

}
