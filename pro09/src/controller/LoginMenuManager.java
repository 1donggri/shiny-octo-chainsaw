package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.vo.Student;
import model.vo.Teacher;

public class LoginMenuManager {
	// 해당 프로그램을 사용하기 위한 로그인 기능
	
	Scanner sc = new Scanner(System.in);
	private TeacherDatabaseManager tDB = new TeacherDatabaseManager();
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	private DatabaseManager sDB = new DatabaseManager();
	
	public void main() {
		StringBuilder loginMenu = new StringBuilder();
		loginMenu.append("1. 교사용 로그인\n");	// teacherLogin()
		loginMenu.append("2. 학생용 로그인\n");	// studentLogin()
		loginMenu.append("3. 패스워드 초기화\n");
		loginMenu.append("9. 종료\n");		// System.exit(0);
		loginMenu.append(">>> ");
		
		while(true) {
			System.out.println(loginMenu);
			
			String input = sc.nextLine();
			
			_clear();
			if(input.equals("1")) {
				teacherLogin();
			} else if(input.equals("2")) {
				studentLogin();
			} else if(input.equals("3")) {
				resetPass();
			} else if(input.equals("9")) {
				System.exit(0);
			}
			_clear();
		}
	}
	
	private void _clear() {
		for(int i = 0; i < 20; i++) {
			System.out.print("\n");
		}
	}
	
	private void teacherLogin() {
		System.out.print("교사명 : ");
		String username = sc.nextLine();
		
		/*
		 * 로그인 검사 후 로그인이 성공하면
		 * 최근 로그인 시간과 현재 로그인 시간을 출력하고
		 * Teacher 객체에는 현재 로그인 시간을 loginDate 에
		 * 저장 후 MenuManager 를 실행한다.
		 * 
		 * 고명환 선생님이 접속하였습니다.
		 * 최근 접속 시간은 2022년 04월 04일 18시 30분 34초 입니다.
		 * 현재 로그인 시간은 2022년 04월 05일 09시 30분 30초 입니다.
		 * 
		 * 1. 성적 조회
		 * 2. 학생 정보 추가
		 * ...
		 * ...
		 */
		
		Teacher loginAccount = null;
		
		for(int i = 0; i < 3; i++) {
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			loginAccount = tDB.login(username, password);
			if(loginAccount != null) {
				break;
			}
		}
		
		if(loginAccount == null) {
			System.out.println("로그인에 실패하였습니다. 다시 시도하세요.");
		} else {
			if(loginAccount.getLoginDate() == null) {
				System.out.println("환영합니다. 첫 로그인 입니다.");
			} else {
				Date now = new Date();
				System.out.println("최근 접속 시간은 " + loginAccount.getLoginDateFormat() + " 입니다.");
				System.out.println("현재 로그인 시간은 " + sFormat.format(now) + " 입니다.");
				loginAccount.setLoginDate(now);
			}
			MenuManager tMenu = new MenuManager(loginAccount);
			tMenu.main();
		}
		
	}
	
	private void studentLogin() {
		System.out.print("학생명 : ");
		String username = sc.nextLine();
		
		Student loginAccount = null;
		
		for(int i = 0; i < 3; i++) {
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			loginAccount = sDB.login(username, password);
			if(loginAccount != null) {
				break;
			}
		}
		
		if(loginAccount == null) {
			System.out.println("로그인에 실패하였습니다. 다시 시도하세요.");
		} else {
			Date now = new Date();
			System.out.println("현재 접속 시간은 " + sFormat.format(now) + " 입니다.");

			MenuManager sMenu = new MenuManager(loginAccount);
			sMenu.main();
		
		}
		
	}
	
	private void resetPass() {
		
	}

}
