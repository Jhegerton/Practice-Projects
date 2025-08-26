package objects;
public class GeometryCalculator extends Geometry{
	
	private Float x;
	private Float y;
	private Float z;
	private Float r;
	
	
	public GeometryCalculator() {
		super();
	}
	
	public GeometryCalculator(Double x, Double y, Double z, Double r) {
		super();
		this.x = Float.valueOf(x.toString());
		this.y = Float.valueOf(y.toString());
		this.z = Float.valueOf(z.toString());
		this.r = Float.valueOf(r.toString());
		
	}

	@Override
	public Float x() {
		return this.x;
	}

	@Override
	public void x(Float x) {
		this.x = x;
	}

	@Override
	public Float y() {
		return this.y;
	}

	@Override
	public void y(Float y) {
		this.y = y;
	}

	@Override
	public Float z() {
		return this.z;
	}

	@Override
	public void z(Float z) {
		this.z = z;
	}

	@Override
	public Float r() {
		return this.r;
	}

	@Override
	public void r(Float r) {
		this.r = r;
	}

	@Override
	public Float area() {
		return this.x * this.y;
	}

	@Override
	public Float perimeter() {
		return 2 *(this.x + this.y);
	}

	@Override
	public Float volume() {
		return this.x * this.y * this.z;
	}

	@Override
	public Float circumference() {
		return 2 * PI * this.r;
	}

	@Override
	public Float diameter() {
		return 2 * this.r;
	}

	@Override
	public Float cArea() {
		Double doubleCArea = PI * Math.pow(Double.valueOf(this.r.toString()),2.0);
		return Float.valueOf(doubleCArea.toString());
	}

	@Override
	public Float cVolume() {
		Double doubleCVolume = (4.0/3.0) * (PI * Math.pow(Double.valueOf(this.r.toString()),3.0));
		return Float.valueOf(doubleCVolume.toString());
	}

}
