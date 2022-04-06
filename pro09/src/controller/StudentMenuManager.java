package controller;

import java.util.Scanner;

import model.vo.Grade;
import model.vo.Student;

public class StudentMenuManager {
	// 학생용 메뉴
	
	private DatabaseManager db = new DatabaseManager();
	private Scanner sc = new Scanner(System.in);
	private Student loginAccount;
	
	public StudentMenuManager(Student loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public void main() {
		StringBuilder menu = new StringBuilder();
		menu.append("1. 조회\n");		// searchMenu()
		menu.append("2. 패스워드 변경\n");
		menu.append("9. 로그아웃\n");	// logout()
		menu.append(">>> ");
		while(true) {
			System.out.println(menu);
			
			String input = sc.nextLine();

			if(input.equals("1")) {
				searchMenu();
			} else if(input.equals("9")) {
				logout();
				return;
			}
		}
	}
	
	private void logout() {
		
	}
	
	private void searchMenu() {
		String name = "";
		Grade[] datas = null;
		
		while(true) {
			name = loginAccount.getName();
			datas = db.search(name);
			
			if(datas == null) {
				System.out.println("해당 학생은 존재하지 않습니다. 다시 입력하세요.");
			} else {
				break;
			}
		}
		
		String result = _printGrades(name, datas);
		System.out.println(result);
		System.out.print("[[엔터키를 입력하세요]]");	sc.nextLine();
		
	}
	
	private String _printGrades(String name, Grade[] datas) {
		String hLine = "--------------------\n";
		StringBuilder sb = new StringBuilder();
		String[] scores = new String[datas.length];
		String[] levels = new String[datas.length];
		String[] subjects = new String[datas.length];
		double avg = 0;
		
		for(int i = 0; i < datas.length; i++) {
			scores[i] = Double.valueOf(datas[i].getScore()).toString();
			levels[i] = Character.valueOf(datas[i].getLevel()).toString();
			subjects[i] = datas[i].getName();
			avg += datas[i].getScore();
		}
		avg /= datas.length;
		
		sb.append(hLine);
		sb.append(String.format("이름 : %s\n", name));
		sb.append(hLine);
		sb.append(String.join("\t", subjects) + "\n");
		sb.append(String.join("점\t", scores) + "점\n");
		sb.append(String.join("등급\t", levels) + "등급\n");
		sb.append(hLine);
		sb.append(String.format("평균 : %.2f 점\n", avg));
		sb.append(hLine);
		
		return sb.toString();
	}


}
