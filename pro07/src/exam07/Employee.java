package exam07;

public class Employee {
	
	private String name;
	private int age;
	private char gender;
	private int income;
	
	public Employee (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void payMonth() {
		System.out.printf("지급액 : %.1f \n", (double)getIncome() / 12);
	}
	
	public void bonus(int month) {
		System.out.printf("보너스 : %.1f \n", (double)getIncome() * 0.25);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	

	
}
