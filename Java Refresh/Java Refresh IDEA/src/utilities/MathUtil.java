/// @author Harrison Egerton
/// package for utility classes
package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class defines math utility methods
 */
public class MathUtil {

    private static MathUtil instance;
    private static UtilityFunctions U =
            UtilityFunctions.getInstance();

    /**
     * hidden constructor
     */
    private MathUtil(){
        super();
    }

    /**
     * Singleton instantiation method
     * @return MathUtil instance
     */
    public static MathUtil getInstance(){
        if(MathUtil.instance == null){
            MathUtil.instance = new MathUtil();
        }
        return MathUtil.instance;
    }

    /**
     * recursively returns the prime factorization
     * @param num number to factor
     * @return array of prime factors
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
     * evaluates whether an integer is prime
     * @param num number to check for prime
     * @return whether the number is prime
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
     * finds greatest common factor
     * @param num1 first number
     * @param num2 second number
     * @return greatest common factor for both numbers
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
     * redefines the toString for MathUtil objects
     * @return String version of self
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
