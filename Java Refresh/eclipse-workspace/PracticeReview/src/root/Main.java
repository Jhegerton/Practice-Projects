package root;

import objs.Person;
import utils.UtilityFunctions;

/**
 * this is the Main method class
 */
class Main {
	/**
	 * this is the main entry method
	 * @param args (command line)
	 */
	public static void main(String[] args) {	
		var person1 = new Person("Susan", "234-555-2167", 21, 8, 2001);
		var person2 = new Person("Frank", "256-555-7864", 1, 2, 1997);
		var person3 = new Person("Susan", "178-555-2098", 13, 7, 1987);
		
		Person[] people = {person1, person2, person3};
		
		
		UtilityFunctions.printAll(true, people);
	}
}