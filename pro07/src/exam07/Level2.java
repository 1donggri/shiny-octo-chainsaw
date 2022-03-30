package exam07;

public class Level2 extends Employee {
	
	private int cardTotal;
	
	public int getCardTotal() {
		return cardTotal;
	}

	public void setCardTotal(int cardTotal) {
		this.cardTotal = cardTotal;
	}

	public Level2(String name, int age) {
		super(name, age);
		this.setIncome(3000);
	}
	
	@Override
	public void bonus(int month) {
		switch(month){
		case 6:	case 12:
			super.bonus(month);
		}
	}
	
	public void card(int amount) {
		if((getIncome() * 0.015) * 10000 > cardTotal + amount) {
			System.out.printf("%d 원을 법인 카드로 결제하였습니다. \n", amount);
			setCardTotal(getCardTotal() + amount);
		} else {
			System.out.println("법인 카드 한도를 초과하였습니다.");
			System.out.printf("현재까지 사용액은 %d 원 입니다. \n", getCardTotal());
			System.out.printf("한도 내에서 %.0f 원 만큼만 사용할 수 있습니다. \n", (getIncome()*0.015) * 10000 - getCardTotal());
		}
	}
	
	

}
