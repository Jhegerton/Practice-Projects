/// @author Harrison Egerton
/// @package For standard classes with public constructors.
package objects;
import struct.Geometry;
import utilities.UtilityFunctions;

/**
 * This class defines simple geometry calculations.
 */
public class GeometryCalculator extends Geometry {

    // define class variables
	private static final UtilityFunctions U = UtilityFunctions.getInstance();

    // define geometry calculator object variables
	private Float x; // length
	private Float y; // width
	private Float z; // height
	private Float r; // radius

    /**
     * The default constructor.
     */
    public GeometryCalculator() {
        super();
    }

    /**
     * The alternate constructor with length, width, and height only.
     * @param x The length of the rectangular prism.
     * @param y The width of the rectangular prism.
     * @param z The height of the rectangular prism.
     */
	public GeometryCalculator(
            Double x,
            Double y,
            Double z
    ) {
		super();
        this.x = Float.valueOf(
                z.toString()
        );
        this.y = Float.valueOf(
                y.toString()
        );
        this.z = Float.valueOf(
                z.toString()
        );
	}

    /**
     * The alternate constructor radius only
     * @param r The radius of the circle.
     */
    public GeometryCalculator(
            Double r
    ) {
        super();
        this.r = Float.valueOf(
                r.toString()
        );
    }

    /**
     * alternate constructor for all variables
     * @param x The length of the rectangular prism.
     * @param y The width of the rectangular prism.
     * @param z The height of the rectangular prism.
     * @param r The radius of the circle.
     */
	public GeometryCalculator(
            Double x,
            Double y,
            Double z,
            Double r
    ) {
		super();
		this.x = Float.valueOf(
                x.toString()
        );
		this.y = Float.valueOf(
                y.toString()
        );
		this.z = Float.valueOf(
                z.toString()
        );
		this.r = Float.valueOf(
                r.toString()
        );
		
	}

    /**
     *  The getter of the length.
     * @return The length of the prism.
     */
	@Override
	public Float x() {
        return this.x;
    }

    /**
     * The setter of the length.
     * @param x The length of the prism
     */
	@Override
	public void x(Float x) {
		this.x = x;
	}

    /**
     * The getter of the width.
     * @return The width of the prism.
     */
	@Override
	public Float y() {
        return this.y;
    }

    /**
     * The setter of the width.
     * @param y The width of the prism
     */
	@Override
	public void y(Float y) {
		this.y = y;
	}

    /**
     * The getter of the height.
     * @return The height of the prism.
     */
	@Override
	public Float z() {
        return this.z;
    }

    /**
     * The setter of the height.
     * @param z The height of the prism.
     */
	@Override
	public void z(Float z) {
		this.z = z;
	}

    /**
     * The getter of the radius.
     * @return The radius of the circle.
     */
	@Override
	public Float r() {
        return this.r;
    }

    /**
     * The setter of the radius
     * @param r The radius of the circle.
     */
	@Override
	public void r(Float r) {
		this.r = r;
	}

    /**
     * This method finds the area of a rectangle.
     * @return The area of a rectangle.
     */
	@Override
	public Float area() {
        // area = x * y
		return this.x * this.y;
	}

    /**
     * This method finds the perimeter of a rectangle.
     * @return The perimeter of a rectangle.
     */
	@Override
	public Float perimeter() {
        // (1) perimeter = x + x + y + y
        // (2) perimeter = (2 * x ) + (2 * y)
		return 2 *
                (this.x + this.y);
	}

    /**
     * This method finds the volume of a rectangular prism.
     * @return The volume of a rectangular prism.
     */
	@Override
	public Float volume() {
        // volume = x * y * z
		return this.x * this.y * this.z;
	}

    /**
     * This method finds the circumference of a circle.
     * @return The circumference of a circle.
     */
	@Override
	public Float circumference() {
        // circumference = 2 * PI * r
		return 2 * PI * this.r;
	}
    /**
     * This method finds the diameter of a circle.
     * @return The diameter of a circle.
     */
	@Override
	public Float diameter() {
        // dimeter = 2 * r
		return 2 * this.r;
	}

    /**
     * This method finds the area of a circle.
     * @return The area of a circle.
     */
	@Override
	public Float cArea() {
        // area = PI * r^2
		double doubleCArea = PI * Math.pow(
                Double.parseDouble(
                        this.r.toString()
                ),2.0
        );
        // return as Float value
		return Float.valueOf(
                Double.toString(doubleCArea)
        );
	}

    /**
     * This method finds the volume of a sphere.
     * @return The volume of a sphere.
     */
	@Override
	public Float cVolume() {
        // volume = 4 * PI * r^3 / 3
		double doubleCVolume = (
                4.0/3.0
        ) * (
                PI * Math.pow(
                        Double.parseDouble(
                                this.r.toString()
                        ),3.0
                )
        );
        // return as Float value
		return Float.valueOf(
                Double.toString(doubleCVolume)
        );
	}

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
	@Override
	public String toString() {
		return String.format(
				"<<class=%s, id=%s> x=%.3f, y=%.3f, z=%.3f, r=%.3f>", 
				U.findMyClass(this),
				this.hashCode(), 
				this.x, 
				this.y, 
				this.z, 
				this.r
				);
	}

}
