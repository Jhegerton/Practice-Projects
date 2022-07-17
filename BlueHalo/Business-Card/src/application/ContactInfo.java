package application;

/**
 * Interface for Contact class
 */
public interface ContactInfo {
    boolean equals(Contact cont); // Evaluates if contact objects are equal.

    String getName(); // Returns the full name of the individual.
    String getPhoneNumber(); // Returns the phone number formatted as a sequence of digits.
    String getEmailAddress(); // Returns the email address.


}

