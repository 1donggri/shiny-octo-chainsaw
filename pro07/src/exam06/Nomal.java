package exam06;

public class Nomal extends Customer {
	
	private int count;
	private int coupon;
	
	@Override
	public void buy(String productName, int price) {
		if(coupon == 1) {
			System.out.println("5% 할인 쿠폰을 적용합니다.");
			double discountPrice = price - (price * 0.05);
			System.out.printf("%s 상품을 %.2f원에 구입하였습니다. \n", productName, discountPrice);
			coupon = 0;
		} else {
			System.out.printf("%s 상품을 %d원에 구입하였습니다. \n", productName, price);
			if(count == 10) {
				System.out.println("구입 횟수가 10회가 되어 5% 할인 쿠폰을 발급합니다.");
				coupon = 1;
				count = 0;
			}
		}
		count ++;	
	}
	
	@Override
	public void refund() {
		System.out.println("일반 고객은 영수증이 있어야 환불을 할 수 있습니다.");
	}

}
