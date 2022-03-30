package exam07;

public class Level1 extends Employee {
	
	public Level1(String name, int age) {
		super(name, age);
		this.setIncome(2800);
	}
	
	@Override
	public void bonus(int month) {
		switch(month){
		case 6:	case 12:
			super.bonus(month);
		}
	}

}
