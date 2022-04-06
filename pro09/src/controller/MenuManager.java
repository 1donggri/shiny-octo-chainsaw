package controller;

import java.util.Date;
import java.util.Scanner;

import model.vo.Account;
import model.vo.Grade;
import model.vo.Student;
import model.vo.Teacher;

public class MenuManager {
	// 학생 성적 관리의 메뉴를 관리하기 위한 매니저 클래스
	
	private Scanner sc = new Scanner(System.in);
	private DatabaseManager db = new DatabaseManager();
	private Account loginAccount;
	
	public MenuManager(Account loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public void main() {
		StringBuilder menu = new StringBuilder();
		menu.append("1. 조회\n");			// searchMenu()
		if(loginAccount instanceof Teacher) {
			menu.append("2. 학생 정보 추가\n");	// studentAddMenu()
			menu.append("3. 성적 정보 수정\n");	// subjectModifyMenu()
			menu.append("4. 학생 정보 삭제\n");	// subjectDeleteMenu()
		}
		menu.append("5. 패스워드 변경\n");
		menu.append("9. 로그아웃\n");	// logout()
		menu.append(">>> ");
		while(true) {
			System.out.println(menu);
			
			String input = sc.nextLine();

			_clear();
			if(input.equals("1")) {
				searchMenu();
			} else if (input.equals("2")) {
				studentAddMenu();
			} else if (input.equals("3")) {
				subjectModifyMenu();
			} else if (input.equals("4")) {
				subjectDeleteMenu();
			} else if(input.equals("9")) {
				logout();
				return;
			}
			_clear();
		}
	}
	
	private void logout() {

	}
	
	private void _clear() {
		for(int i = 0; i < 20; i++) {
			System.out.print("\n");
		}
	}
	
	public void searchMenu() {
		/*
		 * ----------------------
		 * 이름 : 홍길동
		 * ----------------------
		 * 국어   영어   수학   과학
		 * xx점   xx점  xx점  xx점
		 * x등급  x등급  x등급  x등급
		 * ----------------------
		 * 평균 : xx.xx 점
		 */
		String name = "";
		Grade[] datas = null;
		
		while(true) {
			System.out.print("학생 이름 입력 : ");
			name = sc.nextLine();
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
	
	public void studentAddMenu() {
		String name = "";
		
		while(true) {
			System.out.print("학생 이름 입력 : ");
			name = sc.nextLine();
			
			if(db.add(name) == false) {
				System.out.printf("%s 학생의 정보가 추가되었습니다. \n", name);
				System.out.print("[[엔터키를 입력하세요]]");	sc.nextLine();
				break;
			} else {
				System.out.println("해당 학생은 이미 존재하는 정보 입니다.");
			}
		}
	}
	
	public void subjectModifyMenu() {
		String name = "";
		
		while(true) {
			
			System.out.print("학생 이름 입력 : ");
			name = sc.nextLine();
			
			Grade[] datas = db.search(name);
			
			if(db.search(name) == null) {
				System.out.println("학생 이름을 다시 확인해보세요.");
			} else {
				String search = _printGrades(name, datas);
				System.out.print(search);
				
				for(int i = 0; i < datas.length; i++) {
					System.out.printf("%s 점수 입력 : ", datas[i].getName());
					int score = Integer.parseInt(sc.nextLine());
					
					Student std = db.modify(name, datas[i].getName(), score);
					
					System.out.printf("%s 학생의 %s 과목 점수가 수정 되었습니다. \n", std.getName(), datas[i].getName());
					System.out.print("[[엔터키를 입력하세요]]");	sc.nextLine();	
				}
				break;
			}
		}
	}
	
	public void subjectDeleteMenu() {
		String name = "";
		while(true) {
			System.out.println("학생 이름 입력 : ");
			name = sc.nextLine();
			
			if(db.remove(name)) {
				System.out.println("학생 정보를 삭제하였습니다.");
				System.out.print("[[엔터키를 입력하세요]]");	sc.nextLine();
				break;
			} else {
				System.out.println("해당 학생은 존재하지 않습니다. 다시 입력하세요.");
			}
		}	
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
