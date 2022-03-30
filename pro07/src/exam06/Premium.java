package exam06;

import java.util.Objects;

public class Premium extends Customer {
	
	private double discount;
	private int amount;
	
	@Override
	public void buy(String productName, int price) {
		amount += price;
		double p = _calcDiscount(price);
		System.out.printf("%s 상품의 할인율은 %.2f 로 적용되어 %.2f 원에 구입하였습니다. \n", productName, discount, p);
	}
	
	@Override
	public Customer renewal() {
		System.out.println("고객 정보를 갱신합니다.");
		Customer c = this;
		if(amount < 5000000) {
			c = new Nomal();
			c.setName(getName());
			c.setAge(getAge());
			c.setGender(getGender());
			System.out.println("누적사용액이 기준에 미달하여 일반 고객으로 강등 조치되었습니다.");
		}
		return c;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private double _calcDiscount(int price) {
		if(amount >= 10000000) {
			discount = 0.1;
		} else if(amount >= 3000000 && amount < 10000000) {
			discount = 0.05;
		} else if(amount >= 1000000 && amount < 3000000) {
			discount = 0.02;
		} else {
			discount = 0;
		}
		return price - (price * discount);
	}


}
