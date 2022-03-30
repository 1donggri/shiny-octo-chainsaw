package exam07;

public class Level3 extends Level2 {
	
	private int cardTotal;
	private int extraIncome;
	private boolean teamManager;
	
	public Level3(String name, int age) {
		super(name, age);
		this.setIncome(4000);
		this.extraIncome = 0;
	}
	
	@Override
	public void bonus(int month) {
		switch(month){
		case 4:	case 8:	case 12:
			super.bonus(month);
		}
	}
	
//	public void setManger() {
//		if(teamManager == true) {
//			this.extraIncome = teamLeader();
//		} else {
//			this.extraIncome = 0;
//		}
//	}

//	public int teamLeader() {
//		double bonus = this.income * 0.1;
//		return (int)bonus;
//	}

}
