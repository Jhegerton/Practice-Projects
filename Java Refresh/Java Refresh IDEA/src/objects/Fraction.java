package objects;

import errors.DivideByZeroException;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * this class describes a fraction object
 */
public class Fraction {

    // define class variables
    private static final UtilityFunctions u = UtilityFunctions.getInstance();
    private static final MathUtil mu = MathUtil.getInstance();

    // define Fraction object variables
    private Integer numer;
    private Integer denom;

    /**
     * default constructor
     */
    public Fraction(){
        super();
    }

    /**
     * alternate constructor
     * @param numerator numerator of fraction
     * @param denominator denominator of fraction
     */
    public Fraction(int numerator, int denominator){
        try {
            this.numer = numerator;
            if (denominator == 0) {
                // if denominator is zero throw exception
                throw new DivideByZeroException("ERROR:The denominator cannot be zero.");
            } else {
                this.denom = denominator;
            }
        } catch(DivideByZeroException e) {
            e.printStackTrace();

        }
    }

    /**
     * numer getter
     * @return numer numerator of fraction
     */
    public int numer(){
        return this.numer;
    }

    /**
     * numer setter
     * @param numer numerator of fraction
     */
    public void numer(int numer){ this.numer  = numer;}

    /**
     * denom getter
     * @return denom denominator of fraction
     */
    public int denom(){ return this.denom;}

    /**
     * denom setter
     * @param denom denominator of fraction
     */
    public void denom(int denom){
        try {
            if (denom == 0) {
                throw new DivideByZeroException("ERROR:The denominator cannot be zero.");
            } else {
                this.denom = denom;
            }
        } catch(DivideByZeroException e){
            e.printStackTrace();
        }
    }

    /**
     * returns the rational form of the fraction
     * @return rational the decimal form
     */
    public double toRational(){
        return (double) this.numer / (double) this.denom;
    }

    /**
     * addition method for two fractions
     * @param fract fraction to add to self
     * @return newFraction new fraction of sum
     */
   public Fraction add(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer =
                (this.numer * fract.denom) +
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(
                newNumer, newDenom
        );
        newFraction.simplify();
        return newFraction;
   }

    /**
     * substraction method for two fractions
     * @param fract fraction to subtract from self
     * @return newFraction new fraction of the difference
     */
    public Fraction subtract(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer =
                (this.numer * fract.denom) -
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(
                newNumer, newDenom
        );
        newFraction.simplify();
        return newFraction;
    }

    /**
     * multiplication method for two fractions
     * @param fract fraction to multiply from self
     * @return newFraction new fraction of the product
     */
    public Fraction multiply(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer = this.numer * fract.numer;

        Fraction newFraction = new Fraction(
                newNumer, newDenom
        );
        newFraction.simplify();
        return newFraction;
    }

    /**
     * division method for two fractions
     * @param fract fraction to divide by with self
     * @return newFraction new fraction of the quotient
     */
   public Fraction divide(Fraction fract){
       int newDenom = this.denom * fract.numer;
       int newNumer = this.numer * fract.denom;

       Fraction newFraction = new Fraction(
               newNumer, newDenom
       );
       newFraction.simplify();
       return newFraction;
   }

    /**
     * simplifies a Fraction object in place
     */
   public void simplify() {
       // finds greatest common factor
       int gcf = mu.getGCF(
               this.numer, this.denom
       );
       // divides each number by gcf
       // this is always a clean integer division
       this.numer /= gcf;
       this.denom /= gcf;
   }

    /**
     * Fraction toString method
     * @return String version of self
     */
   @Override
   public String toString(){
        return String.format
                ("<<class=%s, id=%s> numer=%d, denom=%d>",
                u.findMyClass(this),
                this.hashCode(),
                this.numer,
                this.denom
                );
   }

}
