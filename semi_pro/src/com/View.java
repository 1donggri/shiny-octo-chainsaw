package com;

import java.util.Scanner;

import com.join.JoinController;
import com.join.JoinVO;
import com.res.ResController;
import com.res.ResVO;

public class View {
	
	private Scanner sc = new Scanner(System.in);
	private Menu menu = new Menu();
	private JoinController jc = new JoinController();
	private ResController rc = new ResController();
	
	public void show() {
		while(true) {
			System.out.print(menu.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					this.joinMenu();	break;
				case "2":
					this.loginMenu();	break;
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void joinMenu() {
		// 회원 가입을 위한 화면과 기능 제공
		JoinVO data = new JoinVO();
		System.out.print("아이디 : ");
		data.setUserID(sc.nextLine());
		System.out.print("패스워드 : ");
		data.setUserPW(sc.nextLine());
		System.out.print("이름 : ");
		data.setUsername(sc.nextLine());
		
		boolean result = jc.join(data);
		
		if(result == true) {
			System.out.println("회원 가입을 축하합니다.");
		} else {
			System.out.println("회원 가입을 할 수 없습니다. (중복된 아이디가 있습니다.)");
		}
		
	}
	
	public void loginMenu() {
		// 로그인을 위한 화면과 기능 제공
		System.out.print("아이디 : ");
		String userid = sc.nextLine();
		System.out.print("패스워드 : ");
		String userpw = sc.nextLine();

		JoinVO account = jc.login(userid, userpw);
		
		if(account != null) {
			System.out.printf("%s 님이 로그인을 하였습니다. \n", account.getUsername());
			afterLoginMenu(account);
		} else {
			System.out.println("로그인을 실패하였습니다.");
		}
	}
	
	public void afterLoginMenu(JoinVO account) {
		while(true) {
			System.out.print(menu.getAfterLogin());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					// 맛집 검색
					this.afterSearchMenu();
					break;
				case "2":
					// 맛집 등록
					ResVO data = new ResVO();
					System.out.print("맛집 이름 : ");
					data.setRes_name(sc.nextLine());
					System.out.print("맛집 종류 (한식, 일식, 중식, 양식) : ");
					data.setRes_type(sc.nextLine());
					System.out.print("맛집 위치 (지역명) : ");
					data.setLocation(sc.nextLine());
					data.setRes_likes(0);
					
					boolean result = rc.join(data);
					
					if(result == true) {
						System.out.println(data.getRes_name() + " 이(가) 맛집으로 등록 되었습니다.");
					} else {
						System.out.println("해당 지역에 이미 등록된 맛집 입니다.");
					}
					
					break;
				case "3":
					// 맛집 수정
					// 좋아요 수는 수정 x
					System.out.println("개발중..");
					break;
				case "4":
					// 맛집 삭제
					System.out.println("개발중..");
					break;
				case "5":
					// 좋아요 누르기
					System.out.println("개발중..");
					break;
				case "6":
					// 로그아웃
					System.out.println("로그아웃 중 입니다.");
					account = null;
					System.out.println("로그아웃 작업이 완료되었습니다.");
					return;
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void afterSearchMenu() {
		while(true) {
			System.out.print(menu.getAfterSearch());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					// 지역별 랭킹
					System.out.println("개발중..");
				case "2":
					// 카테고리별 랭킹
					System.out.println("개발중..");
				case "3":
					// 조건별 검색
					System.out.println("개발중..");
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}

}
