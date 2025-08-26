package exmp;
import objs.Person;
import utils.UtilityFunctions;

/**
 * this class describes example methods
 * using the singleton pattern
 */
public class Example {
	
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
		
		
		UtilityFunctions.printAll(true, people);
		
	}

}