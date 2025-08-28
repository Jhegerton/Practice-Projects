/// @author Harrison Egerton
/// @package For example objects and methods.
package examples;
import objects.GeometryCalculator;
import objects.Person;
import utilities.UtilityFunctions;

/**
 * This class describes example methods.
 */
public class Example {

    private static Example instance;
    private static final UtilityFunctions U =
            UtilityFunctions.getInstance();

    /**
     * Singleton patterns require private constructors.
     */
    private Example() {
        super();
    }

    /**
     * The singleton pattern's instantiation method.
     * @return The same instance of the class each time.
     */
    public static Example getInstance() {
        // check if instance exists
        if (Example.instance == null) {
            // initialize instance
            Example.instance = new Example();
        }
        // return instance
        return Example.instance;
    }

    /**
     * This method executes an example of the Person class.
     */
    public void personExample() {
        var person1 = new Person(
                "Susan",
                "234-555-2167",
                21,
                8,
                2001
        );
        var person2 = new Person(
                "Frank",
                "256-555-7864",
                1,
                2,
                1997
        );
        var person3 = new Person(
                "George",
                "178-555-2098",
                13,
                7,
                1987
        );
        // create a Person array to pass to printALl
        Person[] people = {person1, person2, person3};


        U.printAll(
                true,
                people
        );

    }

    /**
     * This method executes the example of the geometry calculator class.
     */
    public void geometryExample() {
        var calc1 = new GeometryCalculator(
                1.0,
                1.0,
                1.0,
                1.0
        );
        var calc2 = new GeometryCalculator(
                2.5,
                2.5,
                2.5,
                2.5
        );
        var calc3 = new GeometryCalculator(
                3.754,
                3.378,
                3.987,
                3.159
        );
        // create a GeometryCalculator to pass to printAll
        GeometryCalculator[] calcs = {calc1, calc2, calc3};

        U.printAll(
                true,
                calcs
        );

        // iterate over all objects
        for (GeometryCalculator calc : calcs) {
            // run each calculation for each object
            U.println(calc.area());
            U.println(calc.perimeter());
            U.println(calc.volume());
            U.println(calc.circumference());
            U.println(calc.diameter());
            U.println(calc.cArea());
            U.println(calc.cVolume());
        }
    }

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
	public String toString() {
		return String.format(
				"<<class=%s, id=%s>>", 
				U.findMyClass(this),
				this.hashCode()
				);
	}

}



