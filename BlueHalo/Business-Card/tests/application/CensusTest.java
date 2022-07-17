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

    @Test
    void testCheckNames() {
        assertTrue(checkNames(commonName));
        assertFalse(checkNames(rareName));
    }
}