package constants;

/**
 * This class defines enums for various types of constants.
 */
public class Enums {

    /**
     * The default constructor is private to disallow instantiation.
     */
    private Enums(){
        super();
    }
	
	/**
	 * Defines the enum for integer constants.
	 */
	public static enum IntegerEnum {
		MAX_RETRIES_PRINTALL(1);
		
		private final int num;
		
		/**
		 * The default constructor.
		 * @param num This is an integer constant.
		 */
		IntegerEnum(int num){
            this.num  = num;
		}
		
		/**
		 * A getter for the integer constant for individual enumerations.
		 * @return The defined integer constant.
		 */
		public int get() {
            return this.num;
		}
	}

}
