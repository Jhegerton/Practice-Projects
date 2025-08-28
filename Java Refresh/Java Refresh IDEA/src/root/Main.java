/**
 * @author Harrison Egerton
 */
package root;

import examples.Example;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * this is the Main method class
 */
class Main {
	
	private static Example example = Example.getInstance();
	private static UtilityFunctions u = UtilityFunctions.getInstance();
    private static MathUtil mu = MathUtil.getInstance();
	
	/**
	 * this is the main entry method
	 * @param args (command line)
	 */
	public static void main(String[] args) {
        Integer[] factors = mu.primeFactor(20);
        u.printAll(false, factors);

	}
}

