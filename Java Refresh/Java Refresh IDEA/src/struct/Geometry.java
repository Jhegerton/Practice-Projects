package struct;

public abstract class Geometry {
	protected static final Float PI = Float.valueOf("3.14");

	public abstract Float x();
	public abstract void x(Float x);
	
	public abstract Float y();
	public abstract void y(Float y);
	
	public abstract Float z();
	public abstract void z(Float z);
	
	public abstract Float r();
	public abstract void r(Float r);
	
	
	public abstract Float area();
	public abstract Float perimeter();
	public abstract Float volume();
	public abstract Float circumference();
	public abstract Float diameter();
	public abstract Float cArea();
	public abstract Float cVolume();
	
	
}
