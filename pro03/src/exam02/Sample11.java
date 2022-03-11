package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 난수값(랜덤값) 생성
		 * 		import java.util.Random; 를 임포트한 후 다음의 코드 작성
		 */
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(10)); // 0 ~ 9 사이의 난수값 생성
		}
		
		// 실습문제
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		String user = s.nextLine();
		int com = random.nextInt(3);
		
		int win = 0, same = 0, lose = 0;
		int a = 0;
		int result;
		String Scom;
		
		for (;;) {
			System.out.print("가위바위보 : ");
			String player = s.next();
			
			if (player.equals("가위")) {
				System.out.printf("%s : %s \n", user, player);
				a += 1;
				if (com == 0) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("비겼습니다.");
					same++;
				} else if (com == 1) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				} else if (com == 2) {
					System.out.println("컴퓨터 : 보");
					System.out.println("이겼습니다 !");
					win++;
				}
			} else if (player.equals("바위")) {
				System.out.printf("%s : %s \n", user, player);
				a += 1;
				if (com == 0) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("이겼습니다 !");
					win++;
				} else if (com == 1) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("비겼습니다.");
					same++;
				} else if (com == 2) {
					System.out.println("컴퓨터 : 보");
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				}
			} else if (player.equals("보")) {
				System.out.printf("%s : %s \n", user, player);
				a += 1;
				if (com == 0) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				} else if (com == 1) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("이겼습니다 !");
					win++;
				} else if (com == 2) {
					System.out.println("컴퓨터 : 보");
					System.out.println("비겼습니다.");
					same++;
				}
			} else if (player.equals("exit")){
				System.out.printf("%d전 %d승 %d무 %d패", a, win, same, lose);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		
		}
		

	}

}
