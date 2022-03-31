package exam07;

public class Level3 extends Employee implements TeamManager {
	
	private int cardTotal;
	private boolean teamManager;
	
	public Level3(String name, int age) {
		super(name, age);
		this.setIncome(4000);
	}
	
	public boolean isTeamManager() {
		return teamManager;
	}


	public void setTeamManager(boolean teamManager) {
		this.teamManager = teamManager;
	}


	public int getCardTotal() {
		return cardTotal;
	}

	public void setCardTotal(int cardTotal) {
		this.cardTotal = cardTotal;
	}
	
	@Override
	public void bonus(int month) {
		switch(month){
		case 4:	case 8:	case 12:
			super.bonus(month);
		}
	}

	@Override
	public void teamPayBonus() {
		// 팀장 직책을 수행하는 경우 연봉의 10%를 보너스로 받을 수 있습니다.
		if(teamManager == true) {
			System.out.printf("팀장직 수행 보너스 : %.1f 만원 \n", getIncome() / 0.1 / 12);
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
