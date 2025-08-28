/// @author Harrison Egerton
/// @package For abstract classes and interfaces.
package struct;

/**
 * Describes the structure of the Geometry subclasses.
 */
public abstract class Geometry {

    /**
     * This is a constructor which allows for no instantiation outside of inheritance.
     */
    protected Geometry(){
        super();
    }

    // PI constant for child classes
	protected static final Float PI = Float.valueOf("3.14");

    // setter/getters for x
	public abstract Float x();
	public abstract void x(Float x);

    // setters/getters for y
	public abstract Float y();
	public abstract void y(Float y);

    // setters/getters for z
	public abstract Float z();
	public abstract void z(Float z);

    // setters/getters for r
	public abstract Float r();
	public abstract void r(Float r);
	
	// calculation methods
	public abstract Float area();
	public abstract Float perimeter();
	public abstract Float volume();
	public abstract Float circumference();
	public abstract Float diameter();
	public abstract Float cArea();
	public abstract Float cVolume();
	
	
}
