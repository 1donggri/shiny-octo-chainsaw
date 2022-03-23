package exam10;

public class Product {
	
	private String pName = "키보드";
	private int price = 250000;
	private String brand = "X오X드";
	
	public Product() {}
	
	public void information() {
		System.out.printf("품명 : %s \n가격 : %d \n브랜드명 : %s \n", pName, price, brand);
	}

}
