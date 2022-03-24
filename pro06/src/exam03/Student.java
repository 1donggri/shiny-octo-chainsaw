package exam03;

import java.util.*;

public class Student {
	
	private String name;
	private int age;
	private int grade;
	private int group;
	private int number;
	
	public Student() {}
	
	public Student(String name) {
		this(name, 14, 1);
	}
	
	public Student(String name, int age) {
		this(name, age, 1);
	}
	
	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void nextYear() {
		this.age ++;	this.grade ++;
		this.group = this._assignGroup();
		
		if(this.grade > 3) {
			this._graduate();
		}
	}
	
	private int _assignGroup() {
		Random rand = new Random();
		return rand.nextInt(9) + 1;
	}
	
	private void _graduate() {
		this.grade = -1;	this.group = -1;
		this.number = -1;
	}
	
	public String toString() {
		return String.format("%s(%d): %d 학년 % 반", this.name, this.age, this.grade, this.group);
	}
	

}
