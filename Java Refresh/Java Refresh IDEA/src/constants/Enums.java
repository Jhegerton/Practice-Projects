/// @author Harrison Egerton
/// @this package is for constant definition classes
package constants;

/**
 * this class defines enums for various types of constants
 */
public class Enums {
	
	/**
	 * enum for integer constants
	 */
	public static enum IntegerEnum {
		MAX_RETRIES_PRINTALL(1);
		
		private final int num;
		
		/**
		 * constructor
		 * @param num integer constant
		 */
		IntegerEnum(int num){
            this.num  = num;
		}
		
		/**
		 * value getter
		 * @return num
		 */
		public int get() {
            return this.num;
		}
	}

}
