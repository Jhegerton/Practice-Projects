package root;

import examples.Example;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * This is the main method entry class.
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
	 * This is the main entry method.
	 * @param args The command line arguments.
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

