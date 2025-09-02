package objects;

import errors.DivideByZeroException;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * This class describes a fraction object.
 */
public class Fraction {

    // define class variables
    private static final UtilityFunctions U =
            UtilityFunctions.getInstance();
    private static final MathUtil MU =
            MathUtil.getInstance();

    // define Fraction object variables
    private Integer numer; // numerator
    private Integer denom; // denominator

    /**
     * The default constructor.
     */
    public Fraction(){
        super();
    }

    /**
     * This is the copy constructor.
     * @param frac The fraction to make an identical object.
     */
    public Fraction(Fraction frac){
        this.numer = frac.numer;
        this.denom = frac.denom;
    }

    /**
     * The alternate constructor.
     * @param numerator The numerator of the fraction.
     * @param denominator The denominator of the fraction.
     */
    public Fraction(
            int numerator,
            int denominator
    ){
        try {
            this.numer = numerator;
            if (denominator == 0) {
                // if denominator is zero throw exception
                throw new DivideByZeroException(
                        "ERROR:The denominator cannot be zero."
                );
            } else {
                this.denom = denominator;
            }
        } catch(DivideByZeroException e) {
            e.printStackTrace();

        }
    }

    /**
     * The getter for the numerator
     * @return The numerator of the fraction.
     */
    public int numer(){
        return this.numer;
    }

    /**
     * The setter for the numerator.
     * @param numer The number to set for the numerator.
     */
    public void numer(int numer){
        this.numer  = numer;}

    /**
     * The getter for the denominator
     * @return The denominator of the fraction.
     */
    public int denom(){
        return this.denom;}

    /**
     * The setter for the denominator
     * @param denom The number to set for the denominator.
     */
    public void denom(int denom){
        try {
            if (denom == 0) {
                throw new DivideByZeroException(
                        "ERROR:The denominator cannot be zero."
                );
            } else {
                this.denom = denom;
            }
        } catch(DivideByZeroException e){
            e.printStackTrace();
        }
    }

    /**
     * This method finds the rational equivalent of the fraction.
     * @return The fraction in decimal form.
     */
    public double toRational(){
        return
                (double) this.numer /
                (double) this.denom
        ;
    }

    /**
     * This method adds two fractions.
     * @param fract The fraction to add to this fraction object.
     * @return The sum in fraction form.
     */
   public Fraction add(
           Fraction fract
   ){
        int newDenom = (
                this.denom * fract.denom
        );
        int newNumer =
                (this.numer * fract.denom) +
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(
                newNumer,
                newDenom
        );
        newFraction.simplify();
        return newFraction;
   }

    /**
     * The method subtracts two fractions.
     * @param fract  The fraction to subtract from this fraction object.
     * @return The difference in fraction form.
     */
    public Fraction subtract(
            Fraction fract
    ){
        int newDenom = this.denom * fract.denom;
        int newNumer =
                (this.numer * fract.denom) -
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(
                newNumer,
                newDenom
        );
        newFraction.simplify();
        return newFraction;
    }

    /**
     * This method multiplies two fractions.
     * @param fract The fraction to multiply with this fraction object.
     * @return The product in fraction form.
     */
    public Fraction multiply(
            Fraction fract
    ){
        int newDenom = this.denom * fract.denom;
        int newNumer = this.numer * fract.numer;

        Fraction newFraction = new Fraction(
                newNumer,
                newDenom
        );
        newFraction.simplify();
        return newFraction;
    }
    /**
     * This method divides two fractions.
     * @param fract The fraction this fraction object will divide by.
     * @return The quotient in fraction form.
     */
   public Fraction divide(Fraction fract){
       int newDenom = this.denom * fract.numer;
       int newNumer = this.numer * fract.denom;

       Fraction newFraction = new Fraction(
               newNumer,
               newDenom
       );
       newFraction.simplify();
       return newFraction;
   }

    /**
     * This method simplifies a fraction object in place.
     */
   public void simplify() {
       // finds greatest common factor
       int gcf = MU.getGCF(
               this.numer,
               this.denom
       );
       // divides each number by gcf in place
       // this is always a clean integer division
       this.numer /= gcf;
       this.denom /= gcf;
   }

    /**
     * This method tests for deep equals
     * @param fraction a fraction to test for equality.
     * @return Whether the fraction are equal.
     */
   public boolean equals(Fraction fraction){
       var tempFraction1 = new Fraction(this);
       var tempFraction2 = new Fraction(fraction);
       tempFraction1.simplify();
       tempFraction2.simplify();
       return tempFraction1.numer == tempFraction2.numer() &&
               tempFraction1.denom == tempFraction2.denom();
   }

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
   @Override
   public String toString(){
        return String.format
                ("<<class=%s, id=%s> numer=%d, denom=%d>",
                U.findMyClass(this),
                this.hashCode(),
                this.numer,
                this.denom
                );
   }

}
