package exam07;

public class Level5 extends Employee implements TeamManager, HeadManager {
	
	private int cardTotal;
	private boolean teamManager;
	private boolean headManager;
	
	public Level5(String name, int age) {
		super(name, age);
		this.setIncome(8000);
	}
	
	@Override
	public void bonus(int month) {
		switch(month){
		case 1:
			super.bonus(month);
		}
	}

	public boolean isTeamManager() {
		return teamManager;
	}

	public void setTeamManager(boolean teamManager) {
		this.teamManager = teamManager;
	}

	public boolean isHeadManager() {
		return headManager;
	}

	public void setHeadManager(boolean headManager) {
		this.headManager = headManager;
	}

	public void headPayBonus() {
		if(headManager == true) {
			System.out.printf("본부장직 수행 보너스 : %.1f 만원 \n", getIncome() / 0.2 / 12);
		}
	}

	@Override
	public void teamPayBonus() {
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

	public int getCardTotal() {
		return cardTotal;
	}

	public void setCardTotal(int cardTotal) {
		this.cardTotal = cardTotal;
	}

}
