package examples;
import objects.GeometryCalculator;
import objects.Person;
import utilities.UtilityFunctions;

/**
 * this class describes example methods
 * using the singleton pattern
 */
public class Example {
	
	private static final UtilityFunctions u = UtilityFunctions.getInstance();
	
	/**
	 * private constructor
	 */
	private Example() {}
	
	/**
	 * instantiation
	 * @return Example
	 */
	public static Example getInstance() {
		return new Example();
	}
	
	public void personExample(){
		var person1 = new Person("Susan", "234-555-2167", 21, 8, 2001);
		var person2 = new Person("Frank", "256-555-7864", 1, 2, 1997);
		var person3 = new Person("George", "178-555-2098", 13, 7, 1987);
		
		Person[] people = {person1, person2, person3};
		
		
		u.printAll(true, people);
		
	}
	
	public void geometryExample() {
		var calc1 = new GeometryCalculator(1.0,1.0,1.0,1.0);
		var calc2 = new GeometryCalculator(2.0,2.0,2.0,2.0);
		var calc3 = new GeometryCalculator(3.0,3.0,3.0,3.0);
		
		GeometryCalculator[] calcs = {calc1, calc2, calc3};
		
		for (GeometryCalculator calc : calcs) {
			u.println(calc.area());
			u.println(calc.perimeter());
			u.println(calc.volume());
			u.println(calc.circumference());
			u.println(calc.diameter());
			u.println(calc.cArea());
			u.println(calc.cVolume());
		}
		
	}

}



