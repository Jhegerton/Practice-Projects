package utilities;
import java.util.ArrayList;

import constants.Enums.IntegerEnum;
import errors.PrintException;


/**
 * This class describes useful functions
 */
public class UtilityFunctions {
	
	/**
	 * private constructor
	 */
	private UtilityFunctions() {}
	
	/**
	 * singleton instantiation
	 * @return UtilityFunctions
	 */
	public static UtilityFunctions getInstance() {
		return new UtilityFunctions();
	}
	
	/**
	 * converts an array of any type to an array of strings
	 * @param objs
	 * @return string array
	 */
	public String[] convertAllToString(Object[] objs) {
		ArrayList<String> tempList = new ArrayList<>();
		
		for(Object obj: objs) {
			tempList.add(obj.toString());
		}
		
		return tempList.toArray(new String[0]);
	}
	
	// Recursive Functions
	
	/**
	 * prints out any number of objects passed
	 * @param newlines
	 * @param objs
	 */
	public void printAllRecursive(boolean newlines, Object[] objs, int tries) throws PrintException{
		
		if(tries > IntegerEnum.MAX_RETRIES_PRINTALL.get()) {
			throw new PrintException();
		}
		// if already is an array of strings it prints them out
		else if(objs.getClass().getComponentType() == String.class) {
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
			String[] strs = convertAllToString(objs);
			printAllRecursive(newlines, strs, tries + 1);
		}
		
	}
	
	public void printRecursive(Object obj, int tries) throws PrintException {
		boolean isString = obj.getClass() == String.class;
		
		if(tries > 1) {
			throw new PrintException();
		}
		else if(isString) {
			System.out.print(obj);
		}
		else {
			printRecursive(obj.toString(), tries + 1);
		}
		
	}
	
	public void printlnRecursive(Object obj, int tries) throws PrintException {
		boolean isString = obj.getClass() == String.class;
		
		if(tries > 1) {
			throw new PrintException();
		}
		else if(isString) {
			System.out.println(obj);
		}
		else {
			printlnRecursive(obj.toString(), tries + 1);
		}
		
	}
	
	// Wrapper Functions
	
	/**
	 * printAllRecursive wrapper function
	 * @param newlines
	 * @param objs
	 */
	public void printAll(boolean newlines, Object[] objs) {
		try {	
		printAllRecursive(newlines, objs, 0);
		
		}catch(PrintException e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * printRecursive wrapper function
	 * @param obj
	 */
	public void print(Object obj) {
		try {	
		printRecursive(obj, 0);
		
		}catch(PrintException e){
			
			e.printStackTrace();
		}
	}
	
	/**
	 * printlnRecursive wrapper function
	 * @param obj
	 */
	public void println(Object obj) {
		try {	
		printlnRecursive(obj, 0);
		
		}catch(PrintException e){
			
			e.printStackTrace();
		}
	}
	
}

