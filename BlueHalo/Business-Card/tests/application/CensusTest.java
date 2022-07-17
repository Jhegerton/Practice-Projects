package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static application.Census.checkNames;
import static org.junit.jupiter.api.Assertions.*;

class CensusTest {
    String commonName;
    String rareName;

    @BeforeEach
    void setUp() {
        commonName = "Daniels";
        rareName = "Edjerton";
    }

    @AfterEach
    void tearDown() {
        commonName = null;
        rareName = null;
    }

    // Verifies that the check is dependent on the API. The api is returning the 500 most common names. The common name
    // should be present but the rare name should not. This was done in the interest of memory and time.
    @Test
    void testCheckNames() {
        assertTrue(checkNames(commonName));
        assertFalse(checkNames(rareName));
    }
}