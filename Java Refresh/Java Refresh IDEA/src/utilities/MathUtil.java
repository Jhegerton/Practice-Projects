/// @author Harrison Egerton
/// @package For utility classes and methods.
package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class defines the math utility methods.
 */
public class MathUtil {

    private static MathUtil instance;
    private static UtilityFunctions U =
            UtilityFunctions.getInstance();

    /**
     * Singleton patterns require private constructors.
     */
    private MathUtil(){
        super();
    }

    /**
     * The singleton pattern's instantiation method.
     * @return The same instance of the class each time.
     */
    public static MathUtil getInstance(){
        if(MathUtil.instance == null){
            MathUtil.instance = new MathUtil();
        }
        return MathUtil.instance;
    }

    /**
     * This method recursively returns the prime factorization of a number.
     * @param num The number to find the prime factors.
     * @return The array of the number's prime factors.
     */
    public Integer[] primeFactor(int num){
        ArrayList<Integer> factors = new ArrayList<>();

        final int STOP = (int) Math.ceil(
                Math.sqrt(num)
        ); // stop checking for factors at sqrt of num
        for(int i=2; i<=STOP; i++){
            if(num % i == 0){
                // divide and conquer at i
                factors.add(i);
                factors.addAll(
                        List.of(
                                // remove the factor i and
                                // run the method again
                                // with remaining
                                primeFactor(num / i)
                        )
                );
                // return remaining factors as array
                return factors.toArray(
                        new Integer[0]
                );
            }
        }
        // return when num is prime
       return new Integer[] {num}; // prime factors as int array
    }

    /**
     * This method evaluates whether an integer is prime.
     * @param num The number to check if it is prime.
     * @return A boolean that shows whether the number is prime or not.
     */
    public boolean isPrime(int num){
        final int STOP = (int) Math.ceil(
                Math.sqrt(num)
        ); // stop checking for prime at sqrt num
        for(int i=2; i<=STOP; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * This method finds the greatest common factor of two numbers.
     * @param num1 is the first number.
     * @param num2 is the second number.
     * @return The greatest common factor for both numbers.
     */
    public int getGCF(int num1, int num2){
        Set<Integer> num1Factors =
                Set.of(
                        primeFactor(num1)
                ); // get prime factors of num1
        Set<Integer> num2Factors =
                Set.of(
                        primeFactor(num2)
                ); // get prime factors of num2

        Set<Integer> sharedFactors = // creates a list of shared factors
                num1Factors
                .stream()
                .filter(
                        num2Factors::contains
                ) // filter num1Factors for num2Factors
                .collect(
                        // collect factors into a new set
                        Collectors.toSet()
                );

        int  gcf = 1;
        for(int factor : sharedFactors){
            gcf *= factor;
        } // multiply all common factors to find the greatest common factor
        return gcf; // return greatest common factor

    }

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
    @Override
    public String toString(){
        return String.format(
                "<<class=%s, id=%s>>",
                U.findMyClass(this),
                this.hashCode()
                );
    }
}
