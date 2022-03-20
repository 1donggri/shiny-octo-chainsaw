package exam09;

public class Rectangle {
	
	public double width;
	public double height;
	
	public Rectangle() {}
	
	public Rectangle(double width) {
		this.width = width;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		return width * width;
	}
	
	public double round(double width, double height) {
		return (width + height) * 2;
	}

}
