package exam07;

public class Level4 extends Level2 {
	
	private int cardTotal;
	private int extraIncome;
	private boolean teamManager;
	private boolean headManager;
	
	public Level4(String name, int age) {
		super(name, age);
		this.setIncome(5500);
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
//		} else if(headManager == true) {
//			this.extraIncome = director();
//		} else {
//			this.extraIncome = 0;
//		}
//	}

//	public int teamLeader() {
//		double bonus = income * 0.1;
//		return (int)bonus;
//	}
	
//	public int director() {
//		double bonus = income * 0.2;
//		return (int)bonus;
//	}

}
