package exam01;

import java.util.*;

public class Sample02 {
	
	public void ex01() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값을 입력하세요: ");
		String user = sc.nextLine();
		String[] sArr = user.split(" ");
		
		System.out.println("다음의 값을 입력하였습니다.");
		System.out.println(String.join(", ", sArr));
		
	}
	
	public void ex02() {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.print("전화번호를 입력하세요: ");
			String user = sc.nextLine();
			if(user.matches("\\d{3}-\\d{4}-\\d{4}")) {
				System.out.println("입력되었습니다.");
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}
		
	}
	
	public void ex03() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("전화번호를 입력하세요: ");
		String user = sc.nextLine();
		
		user = user.replace(user.substring(user.length() - 4, user.length()), "****");
		System.out.println(user);
	}
	
	public void ex04() {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.print("이메일을 입력하세요: ");
			String user = sc.nextLine();
			String[] email = user.split("@");
			
			if(email.length == 2) {
				if(email[1].equals("gmail.com")) {
					System.out.println("입력되었습니다.");
					break;
				} else if(email[1].equals("naver.com")) {
					System.out.println("입력되었습니다.");
					break;
				} else if(email[1].equals("nate.com")) {
					System.out.println("입력되었습니다.");
					break;
				} else {
					System.out.println("올바른 형식으로 입력해주세요.");
				}
			} else {
				System.out.println("올바른 형식으로 입력해주세요.");
			}
		}
		
	}

	public static void main(String[] args) {
		Sample02 sample = new Sample02();
		sample.ex04();

	}

}
