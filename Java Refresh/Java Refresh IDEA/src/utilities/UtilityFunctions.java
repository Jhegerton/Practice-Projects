/// @author Harrison Egerton
/// package for utility classes
package utilities;
import java.util.ArrayList;
import java.util.List;

import constants.Enums.IntegerEnum;
import errors.PrintException;


/**
 * This class describes useful functions
 */

public class UtilityFunctions {
	
	private static UtilityFunctions instance;
	
	/**
	 * private constructor
	 */
	private UtilityFunctions() {
        super();
    }
	
	/**
	 * singleton instantiation
     * only one instance allowed
	 * @return instance
	 */
	public static UtilityFunctions getInstance() {
		if(UtilityFunctions.instance == null){
			UtilityFunctions.instance = new UtilityFunctions();
		}
		return UtilityFunctions.instance;
	}
	
	/**
	 * converts an array of any type to an array of strings
	 * @param objs array of generic objects
	 * @return string array of all objects
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
	 * prints out any number of objects passed
	 * @param newlines flag for printing in new-line (true) vs inline (false)
	 * @param objs array of generic objects
     * @param tries count of conversion attempts
     * @throws PrintException error from too many attempts to convert
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
     * prints out an object (inline)
     * @param obj a generic object
     * @param tries count of conversion attempts
     * @throws PrintException error from too many attempts to convert
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
     * @param obj a generic object
     * @param tries count of conversion attempts
     * @throws PrintException error from too many attempts to convert
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
	 * printAllRecursive wrapper function
	 * @param newlines flag for new-line (true) vs inline (false)
	 * @param objs array of generic objects
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
	 * printRecursive wrapper function
	 * @param obj a generic object
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
	 * printlnRecursive wrapper function
	 * @param obj a generic object
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
     * extracts the class name from an object as a String
     * @param obj a generic object
     * @return String of the class name of object
     */
	public String findMyClass(Object obj) {
		return obj.getClass(). // git class data
                getName().     // get name output
                // pull the class name from the output
                split("\\.")[1]; // return class name String
	}

    /**
     * redefines the toString for UtilityFunctions objects
     * @return String version of self
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

