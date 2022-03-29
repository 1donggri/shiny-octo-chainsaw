package exam06;

public class Employee extends Customer {
	
	@Override
	public void buy(String productName, int price) {
		double discountPrice = price - (price * 0.1);
		System.out.printf("%s 상품을 %.2f원에 구입하였습니다. \n", productName, discountPrice);
	}

}
