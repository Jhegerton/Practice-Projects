package objects;
import struct.Geometry;
import utilities.UtilityFunctions;

/**
 * this class defines simple geometry calculations
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
     * default constructor
     */
    public GeometryCalculator() {
        super();
    }

    /**
     * alternate constructor x,y,z only
     * @param x length
     * @param y width
     * @param z height
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
     * alternate constructor r only
     * @param r radius
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
     * @param x length
     * @param y width
     * @param z height
     * @param r radius
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
     *  x getter
     * @return x length
     */
	@Override
	public Float x() {
        return this.x;
    }

    /**
     * x setter
     * @param x length
     */
	@Override
	public void x(Float x) {
		this.x = x;
	}

    /**
     * y getter
     * @return y length
     */
	@Override
	public Float y() {
        return this.y;
    }

    /**
     * y setter
     * @param y width
     */
	@Override
	public void y(Float y) {
		this.y = y;
	}

    /**
     * z getter
     * @return z height
     */
	@Override
	public Float z() {
        return this.z;
    }

    /**
     * z setter
     * @param z height
     */
	@Override
	public void z(Float z) {
		this.z = z;
	}

    /**
     * r getter
     * @return r radius
     */
	@Override
	public Float r() {
        return this.r;
    }

    /**
     * r setter
     * @param r radius
     */
	@Override
	public void r(Float r) {
		this.r = r;
	}

    /**
     * finds the area
     * @return area of a rectangle
     */
	@Override
	public Float area() {
        // area = x * y
		return this.x * this.y;
	}

    /**
     * finds the perimeter
     * @return perimeter of a rectangle
     */
	@Override
	public Float perimeter() {
        // (1) perimeter = x + x + y + y
        // (2) perimeter = (2 * x ) + (2 * y)
		return 2 *
                (this.x + this.y);
	}

    /**
     * finds the volume
     * @return volume of a rectangular prism
     */
	@Override
	public Float volume() {
        // volume = x * y * z
		return this.x * this.y * this.z;
	}

    /**
     * finds the circumference
     * @return circumference of a circle
     */
	@Override
	public Float circumference() {
        // circumference = 2 * PI * r
		return 2 * PI * this.r;
	}
    /**
     * finds the diameter
     * @return diameter of a circle
     */
	@Override
	public Float diameter() {
        // dimeter = 2 * r
		return 2 * this.r;
	}

    /**
     * finds the area of a circle
     * @return area of circle
     */
	@Override
	public Float cArea() {
        // area = PI * r^2
		double doubleCArea = PI * Math.pow(
                Double.parseDouble(
                        this.r.toString()
                ),2.0
        );
		return Float.valueOf(
                Double.toString(doubleCArea)
        );
	}

    /**
     * finds the volume of a sphere
     * @return volume of sphere
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
		return Float.valueOf(
                Double.toString(doubleCVolume)
        );
	}

    /**
     * redefines the toString for GeometryCalculator objects
     * @return String version of self
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
