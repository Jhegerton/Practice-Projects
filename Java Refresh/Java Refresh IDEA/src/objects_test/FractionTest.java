package objects_test;

import objects.Fraction;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private static Fraction fract1;
    private static Fraction fract2;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fract1 = new Fraction(1, 2);
        fract2 = new Fraction(2, 3);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        fract1 = null;
        fract2 = null;
        assertNull(fract1, "fract1 is not null");
        assertNull(fract2, "fract2 is not null");
    }

    @org.junit.jupiter.api.Test
    void testNumer() {
        var tempNumer1 = fract1.numer();
        var getterError = buildError("numer getter", tempNumer1, 1);
        assertEquals(1, tempNumer1, getterError);

        fract2.numer(3);
        var tempNumer2 = fract2.numer();
        var setterError = buildError("numer setter", tempNumer2, 3);;
        assertEquals(3, fract2.numer(),setterError);
    }

    @org.junit.jupiter.api.Test
    void testDenom() {
        var tempDenom1 = fract1.denom();

        var getterError = buildError("numer getter", tempDenom1, 2);
        assertEquals(2, tempDenom1, getterError);

        fract2.denom(5);
        var tempDenom2 = fract2.denom();

        var setterError = buildError("numer setter", tempDenom2, 5);;
        assertEquals(5, fract2.denom(),setterError);
    }

    @org.junit.jupiter.api.Test
    void testToRational() {
        var dec = fract1.toRational();

        var error = buildError("to rational", dec, .5);
        assertEquals(.5, dec, error);
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        var sum = fract1.add(fract2);

        var isCorrect =
                sum.numer() == 7 &&
                sum.denom() == 6;

        var error = buildError("add", "sum");
        assertTrue(isCorrect, error);
    }

    @org.junit.jupiter.api.Test
    void testSubtract() {
        var diff = fract2.subtract(fract1);

        var isCorrect =
                diff.numer() == 1 &&
                diff.denom() == 6;

        var error = buildError("subtract", "difference");
        assertTrue(isCorrect, error);
    }

    @org.junit.jupiter.api.Test
    void testMultiply() {
        var prod = fract1.multiply(fract2);

        var isCorrect =
                prod.numer() == 1 &&
                        prod.denom() == 3;

        var error = buildError("multiply", "product");
        assertTrue(isCorrect, error);
    }

    @org.junit.jupiter.api.Test
    void testDivide() {
        var quot = fract1.divide(fract2);

        var isCorrect =
                quot.numer() == 3 &&
                        quot.denom() == 4;

        var error = buildError("divide", "quotient");
        assertTrue(isCorrect, error);
    }

    @org.junit.jupiter.api.Test
    void testSimplify() {
        var fract3 = new Fraction(9, 12);
        fract3.simplify();

        var isCorrect =
                fract3.numer() == 3 &&
                        fract3.denom() == 4;

        var error = buildError("simplify", "output");
        assertTrue(isCorrect, error);
    }

    @org.junit.jupiter.api.Test
    void testEquals(){
        var fract4 = new Fraction(2, 5);
        var fract5 = new Fraction(8, 20);

        var isCorrect = fract4.equals(fract5);
        var error = buildError("equals", "output");
        assertTrue(isCorrect, error);

    }

    @org.junit.jupiter.api.Test
    void testToString() {
        var tempString = fract1.toString();

        var isCorrect = tempString.matches(
                "<<class=Fraction, id=[0-9]*> numer=1, denom=2>"
        );
        var error = buildError("to string", "output");

        assertTrue(isCorrect, error);
    }

    private static String buildError(String method, Object actual, Object expect) {
        return String.format(
                "ERROR %s method failed! %s did not equal %s",
                method,
                actual,
                expect
        );
    }

    private static String buildError(String method, String output) {
        return String.format(
                "ERROR %s method failed! %s is invalid",
                method,
                output
        );
    }
}