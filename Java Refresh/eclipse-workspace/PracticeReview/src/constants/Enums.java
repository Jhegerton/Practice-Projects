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
		 * @param num
		 */
		IntegerEnum(int num){
			this.num  = num;
		}
		
		/**
		 * value getter
		 * @return
		 */
		public int get() {
			return this.num;
		}
	}

}
