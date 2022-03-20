package exam09;

public class Circle {
	
	public final static double PI = 3.14;
	public double r;
	public double area;
	public double round;
	
	public Circle() {}
	
	public Circle(double r) {
		this.r = r;
		_area();
		_round();
	}
	
	// setter
	public void setRadius(double r) {
		this.r = r;
		_area();
		_round();
	}
	
	// getter
	public double getRadius() {
		return r;
	}
	
	// getter
	public double getArea() {
		return area;
	}
	
	// getter
	public double getRound() {
		return round;
	}
	
	// 원 넓이
	private void _area() {
		this.area = r * r * PI;
	}
	
	// 원 둘레
	private void _round() {
		this.round = 2 * PI * r;
	}

}
