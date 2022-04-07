package model.vo;

import java.util.Random;

// 학생 정보를 가지는 클래스
public class Student extends Account {
	/*
	 * 이름(name)과 성적배열(Grade)를 정의
	 * getter/setter 도 작성
	 */
	private Grade[] grades;
	Random rand = new Random();
	
	public Student(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Student(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	@Override
	public boolean changePassword(String curPass, String changePass) {
		if(getPassword().equals(curPass)) {
			setPassword(changePass);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String resetPassword() {
		String newPass = "STD_";
		for(int i = 0; i < 6; i++) {
			char c = (char)(rand.nextInt(25) + 97);
			newPass += c;
		}
		setPassword(newPass);
		return getPassword().substring(4);
	}
	
	


}
