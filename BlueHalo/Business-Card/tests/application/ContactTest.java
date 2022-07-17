package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    Contact defaultContact;
    Contact alternateContact;
    Contact copyContract;

    @BeforeEach
    void setUp() {
        defaultContact = new Contact();
        alternateContact = new Contact("John Smith", "4444444444", "user@email.com");
        copyContract = new Contact(alternateContact);
    }

    @AfterEach
    void tearDown() {
        defaultContact = null;
        alternateContact = null;
        copyContract = null;
        assertNull(defaultContact);
        assertNull(alternateContact);
        assertNull(copyContract);
    }

    // Tests the boilerplate methods for the Contact class for
    // correct behavior.
    @Test
    void testEquals() {
        assertFalse(defaultContact.equals(copyContract));
        assertTrue(alternateContact.equals(copyContract));
    }

    @Test
    void testHashCode() {
        System.out.println(alternateContact.hashCode());
        assertTrue(alternateContact.hashCode() != 0);
        assertNotEquals(11, defaultContact.hashCode());
    }

    @Test
    void setName() {
        defaultContact.setName("Suzie Smith");
        assertEquals("Suzie Smith", defaultContact.getName());
    }

    @Test
    void setPhoneNumber() {
        defaultContact.setPhoneNumber("1234567890");
        assertEquals("1234567890", defaultContact.getPhoneNumber());
    }

    @Test
    void setEmailAddress() {
        defaultContact.setEmailAddress("super@powers.com");
        assertEquals("super@powers.com", defaultContact.getEmailAddress());
    }

    @Test
    void getName() {
        assertEquals("John Smith", alternateContact.getName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("4444444444", alternateContact.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        assertEquals("user@email.com", alternateContact.getEmailAddress());
    }

    @Test
    void testToString() {
        String expectString = "Name : John Smith\nPhone: 4444444444\nEmail: user@email.com";
        assertEquals(expectString, alternateContact.toString());
    }
}