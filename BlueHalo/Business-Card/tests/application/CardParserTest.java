package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {
    String doc;
    Contact contact;

    CardParser parser;

    @BeforeEach
    void setUp() {
        doc = "Chronos Sleep Science&Chief Reseacher&George Johnson&Boston, MA& +1(446) 986 -0947&george@chronsos.net";
        contact = new Contact("George Johnson", "14469860947", "george@chronsos.net");
        parser = new CardParser();
    }

    @AfterEach
    void tearDown() {
        doc = null;
        contact = null;
        parser = null;
        assertNull(doc);
        assertNull(contact);
        assertNull(parser);
    }

    @Test
    void getContactInfo() {
        try{
            assertTrue(contact.equals(parser.getContactInfo(doc)));

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}