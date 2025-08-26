/**
 * @author Harrison Egerton
 */
package root;

import examples.Example;

/**
 * this is the Main method class
 */
class Main {
	
	private static Example example = Example.getInstance();
	/**
	 * this is the main entry method
	 * @param args (command line)
	 */
	public static void main(String[] args) {	
		example.geometryExample();
	}
}

