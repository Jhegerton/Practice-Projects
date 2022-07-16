package application;

import java.io.IOException;

public interface BusinessCardParser{
    ContactInfo getContactInfo(String document) throws Exception;

}
