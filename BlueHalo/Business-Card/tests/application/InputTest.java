package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.InvalidApplicationException;

import static application.Input.getInput;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    String path;

    @BeforeEach
    void setUp() {
        path = "arthur.txt";
    }

    @AfterEach
    void tearDown() {
        path = null;
        assertNull(path);
    }

    // Tests if the output of the get input method is a Contact object.
    @Test
    void testGetInput1() {
        try {
            assertEquals("Contact", getInput(path).getClass().getSimpleName());

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    // Tests for correct exception handling in case of invalid file path format.
    @Test
    void testgetInput2(){
        Exception e = assertThrows(Exception.class, () ->{
            getInput("~");
        });
        assertEquals("~ (The system cannot find the file specified)", e.getMessage());

    }
}