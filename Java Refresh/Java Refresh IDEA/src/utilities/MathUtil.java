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
     * returns the prime factorization
     * @param num number to factor
     * @return array of prime factors
     */
    public Integer[] primeFactor(int num){
        ArrayList<Integer> factors = new ArrayList<>();

        final int STOP = (int) Math.ceil(
                Math.sqrt(num)
        );
        for(int i=2; i<=STOP; i++){
            if(num % i == 0){
                factors.add(i);
                factors.addAll(
                        List.of(
                                primeFactor(num / i)
                        )
                );
                return factors.toArray(
                        new Integer[0]
                );
            }
        }
       return new Integer[] {num};
    }

    /**
     * evaluates whether an integer is prime
     * @param num number to check for prime
     * @return whether the number is prime
     */
    public boolean isPrime(int num){
        final int STOP = (int) Math.ceil(
                Math.sqrt(num)
        );
        for(int i=2; i<=STOP; i++){
            int j = STOP - i + 2;
            if(num % j == 0){
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
                );
        Set<Integer> num2Factors =
                Set.of(
                        primeFactor(num2)
                );

        Set<Integer> sharedFactors =
                num1Factors
                .stream()
                .filter(
                        num2Factors::contains
                )
                .collect(
                        Collectors.toSet()
                );

        int  gcf = 0;
        for(int factor : sharedFactors){
            gcf += factor;
        }
        return gcf;

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
