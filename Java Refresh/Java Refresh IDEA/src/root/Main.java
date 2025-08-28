/// @author Harrison Egerton
/// package for entry class
package root;

import examples.Example;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * this is the Main method class
 */
class Main {

    // Class defined static variables
	private static final Example EXAMPLE =
            Example.getInstance();
	private static final UtilityFunctions U =
            UtilityFunctions.getInstance();
    private static final MathUtil MU =
            MathUtil.getInstance();
	
	/**
	 * this is the main entry method
	 * @param args (command line)
	 */
	public static void main(String[] args) {
        Integer[] factors =
                MU.primeFactor(20);

        U.printAll(
                false,
                factors
        );

	}
}

