package exam09;

public class Triangle {
	
	public int s;
	
	public Triangle(int s) {
		this.s = s;
	}
	
	public void area() {
		int a = s * s / 2;
		System.out.printf("삼각형 넓이 -> %d \n", a);
	}
	
	public void round() {
		int a = s * 3;
		System.out.printf("삼각형 둘레 -> %d \n", a);
	}

}
