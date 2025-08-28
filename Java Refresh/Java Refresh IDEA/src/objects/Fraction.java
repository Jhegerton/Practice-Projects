package objects;

import errors.DivideByZeroException;
import utilities.MathUtil;
import utilities.UtilityFunctions;

/**
 * this class describes a fraction object
 */
public class Fraction {

    private static UtilityFunctions u = UtilityFunctions.getInstance();
    private static MathUtil mu = MathUtil.getInstance();

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
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator){
        try {
            this.numer = numerator;
            if (denominator == 0) {
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
     * @return numer
     */
    public int getNumer(){
        return this.numer;
    }

    /**
     * numer setter
     * @param numer
     */
    public void setNumer(int numer){
        this.numer = numer;
    }

    /**
     * denom getter
     * @return denom
     */
    public int getDenom(){
        return this.denom;
    }

    /**
     * denom setter
     * @param denom
     */
    public void setDenom(int denom){
        this.denom  = denom;
    }

    /**
     * returns the rational form of the fraction
     * @return double
     */
    public double toRational(){
        return (double) this.numer / (double) this.denom;
    }

    /**
     * addition method for two fractions
     * @param fract
     * @return Fraction
     */
   public Fraction add(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer =
                (this.numer * fract.denom) +
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(newNumer, newDenom);
        newFraction.simplify();
        return newFraction;
   }

    /**
     * substraction method for two fractions
     * @param fract
     * @return Fraction
     */
    public Fraction subtract(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer =
                (this.numer * fract.denom) -
                        (fract.numer * this.denom);

        Fraction newFraction = new Fraction(newNumer, newDenom);
        newFraction.simplify();
        return newFraction;
    }

    /**
     * multiplication method for two fractions
     * @param fract
     * @return Fraction
     */
    public Fraction multiply(Fraction fract){
        int newDenom = this.denom * fract.denom;
        int newNumer = this.numer * fract.numer;

        Fraction newFraction = new Fraction(newNumer, newDenom);
        newFraction.simplify();
        return newFraction;
    }

    /**
     * deivision method for two fractions
     * @param fract
     * @return Fraction
     */
   public Fraction divide(Fraction fract){
       int newDenom = this.denom * fract.numer;
       int newNumer = this.numer * fract.denom;

       Fraction newFraction = new Fraction(newNumer, newDenom);
       newFraction.simplify();
       return newFraction;
   }

   public void simplify() {
       int gcf = mu.getGCF(this.numer, this.denom);
       this.numer /= gcf;
       this.denom /= gcf;
   }

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
