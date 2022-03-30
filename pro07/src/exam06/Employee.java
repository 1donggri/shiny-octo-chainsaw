package exam06;

public class Employee extends Customer {
	
	@Override
	public void buy(String productName, int price) {
		int discountPrice = (int)(price - (price * 0.1));
		super.buy(productName, discountPrice);
	}

}
