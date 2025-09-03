package utilities;
import java.util.ArrayList;
import java.util.List;

import constants.Enums.IntegerEnum;
import errors.PrintException;


/**
 * This class describes useful functions for the whole project.
 */

public class UtilityFunctions {
	
	private static UtilityFunctions instance;

    /**
     * Singleton patterns require private constructors.
     */
	private UtilityFunctions() {
        super();
    }

    /**
     * The singleton pattern's instantiation method.
     * @return The same instance of the class each time.
     */
	public static UtilityFunctions getInstance() {
		if(UtilityFunctions.instance == null){
			UtilityFunctions.instance = new UtilityFunctions();
		}
		return UtilityFunctions.instance;
	}
	
	/**
	 * This method converts an array of any type to an array of strings.
	 * @param objs An array of generic objects.
	 * @return A string array of all objects in the original object array.
	 */
	public String[] convertAllToStrings(Object[] objs) {
		// define a temporary list to hold Strings
        List<String> tempList = new ArrayList<>();

        // iterate over all objects in passed array
		for(Object obj: objs) {
            // add the toString output to the list
			tempList.add(obj.toString());
		}
		// return as array of Strings
		return tempList.toArray(new String[0]);
	}
	
	// Recursive Functions
	
	/**
	 * This method prints out any number of objects passed to it.
	 * @param newlines The boolean flag for printing in new-line (true)
     *                    vs inline (false).
	 * @param objs An array of generic objects.
     * @param tries The count of conversion attempts.
     * @throws PrintException The error from too many attempts to convert the objects to strings.
	 */
	public void printAllRecursive(
            boolean newlines,
            Object[] objs,
            int tries
    ) throws PrintException {
		
		if(tries > IntegerEnum.MAX_RETRIES_PRINTALL.get()) {
            // if the recursive goes through more than twice
            // then the recursion will end in a PrintException
			throw new PrintException();
		}
		// checks if it is an array of Strings
		else if(objs
                .getClass()
                .getComponentType() == String.class
        )
        {
            // if the array is already made of Strings
			if(newlines)  // check for newlines flag
            {
				for(Object obj : objs) {
                    // print on new-line for each String
					System.out.println(obj);
				}
			}
			else {
				for(Object obj : objs) {
                    // print on inline for each String
					System.out.print(obj);
				}
			}
		}
		// if the array is not strings it attempts to convert
		// and then recursively retries
		else // the array is not made of Strings
        {
            // attempt to convert all Objects in array
            // to Strings
			String[] strs = convertAllToStrings(objs);

            // attempts to print again
			printAllRecursive(
                    newlines, // keep flag unchanged
                    strs,     // pass the new array
                    ++tries   // increase the count of tries
            );
		}
		
	}

    /**
     * Prints out an object in inline format.
     * @param obj A generic object.
     * @param tries The count of conversion attempts.
     * @throws PrintException The error from too many attempts to convert the object to a string.
     */
	public void printRecursive(
            Object obj,
            int tries
    ) throws PrintException {
        // checks if the object is a String
		boolean isString = obj
                .getClass() == String.class;
		
		if(tries > 1) {
            // if the recursive goes through more than twice
            // then the recursion will end in a PrintException
			throw new PrintException();
		}
		else if(isString) {
            // it is a String and it is printed
			System.out.print(obj);
		}
		else { // it is not a String

            // attempts to print again
			printRecursive(
                    obj.toString(), // convert object to String
                    ++tries         // increase count of tries
            );
		}
		
	}

    /**
     * prints out an object (new-line)
     * @param obj A generic object.
     * @param tries The count of conversion attempts.
     * @throws PrintException The error from too many attempts to convert the object to a string.
     */
	public void printlnRecursive(
            Object obj,
            int tries
    ) throws PrintException {
        // checks if the object is a String
		boolean isString = obj
                .getClass() == String.class;
		
		if(tries > 1) {
            // if the recursive goes through more than twice
            // then the recursion will end in a PrintException
			throw new PrintException();
		}
		else if(isString) {
            // it is a String and is printed in a new-line
			System.out.println(obj);
		}
		else { // it is not a String
            // attempts to print again
			printlnRecursive(
                    obj.toString(), // attempts to convert
                    ++tries         // increase count of tries
            );
		}
		
	}
	
	// Wrapper Functions
	
	/**
	 * The wrapper function for the print all recursive function.
	 * @param newlines The boolean flag for new-line (true) vs inline (false) formatting.
	 * @param objs The array of generic objects.
	 */
	public void printAll(
            boolean newlines,
            Object[] objs
    ) {
		try {
        // starts the printAllRecursive method as wrapper
		printAllRecursive(
                newlines, // passed in
                objs,     // passed in
                0         // tries initialized (wrapper required)
        );
		
		}catch(PrintException e){
			e.printStackTrace(); // print error stack trace
		}
	}
	
	/**
	 * The wrapper function for the print function in inline format.
	 * @param obj A generic object.
     */
	public void print(Object obj) {
		try {	
		printRecursive(
                obj,    // passed in
                0       // tries initialized (wrapper required)
        );
		
		}catch(PrintException e){
			e.printStackTrace(); // print error stack trace
		}
	}
	
	/**
	 * The wrapper function for the print function in new-line format.
	 * @param obj A generic object.
	 */
	public void println(Object obj) {
		try {	
		printlnRecursive(
                obj, // passed in
                0    // tries initialized (wrapper required)
        );
		
		}catch(PrintException e){
			e.printStackTrace(); // print error stack trace
		}
	}

    /**
     * This method extracts the class name from an object.
     * @param obj A generic object.
     * @return The string of the class name of the object.
     */
	public String findMyClass(Object obj) {
		return obj.getClass(). // git class data
                getName().     // get name output
                // pull the class name from the output
                split("\\.")[1]; // return class name String
	}

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
	@Override
	public String toString() {
		return String.format(
				"<<class=%s, id=%s>>", 
				this.findMyClass(this),
				this.hashCode()
				);
	}
}

