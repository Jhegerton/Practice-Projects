package utilities;
import java.util.ArrayList;

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
		ArrayList<String> tempList = new ArrayList<>();
		
		for(Object obj: objs) {
			tempList.add(obj.toString());
		}
		
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
			throw new PrintException();
		}
		// if already is an array of strings it prints them out
		else if(objs.getClass().getComponentType() == String.class
        ) {
			if(newlines) {
				for(Object str : objs) {
					System.out.println(str);
				}
			}
			else {
				for(Object str : objs) {
					System.out.print(str);
				}
			}
		}
		// if the array is not strings it attempts to convert
		// and then recursively retries
		else {
			String[] strs = convertAllToStrings(objs);
			printAllRecursive(
                    newlines,
                    strs,
                    tries + 1
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
		boolean isString = obj
                .getClass() == String.class;
		
		if(tries > 1) {
			throw new PrintException();
		}
		else if(isString) {
			System.out.print(obj);
		}
		else {
			printRecursive(
                    obj.toString(),
                    tries + 1
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
		boolean isString = obj
                .getClass() == String.class;
		
		if(tries > 1) {
			throw new PrintException();
		}
		else if(isString) {
			System.out.println(obj);
		}
		else {
			printlnRecursive(
                    obj.toString(),
                    tries + 1
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
		printAllRecursive(
                newlines,
                objs,
                0
        );
		
		}catch(PrintException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * printRecursive wrapper function
	 * @param obj a generic object
	 */
	public void print(Object obj) {
		try {	
		printRecursive(
                obj,
                0
        );
		
		}catch(PrintException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * printlnRecursive wrapper function
	 * @param obj a generic object
	 */
	public void println(Object obj) {
		try {	
		printlnRecursive(
                obj,
                0
        );
		
		}catch(PrintException e){
			e.printStackTrace();
		}
	}

    /**
     * extracts the class name from an object as a String
     * @param obj a generic object
     * @return String of the class name of object
     */
	public String findMyClass(Object obj) {
		return obj.getClass().
                getName().
                split("\\.")[1];
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

