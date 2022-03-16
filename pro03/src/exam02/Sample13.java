package exam02;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


public class Sample13 {

	public static void main(String[] args) {
		// 배열을 적용한다.
		//		- 컴퓨터가 생성한 정수 값을 가위, 바위, 보로 치환하기 위한 배열
		//		- 전적 기록을 배열을 사용하여 관리할 수 있도록 한다.
		
		Scanner sc = new Scanner(System.in);
		
		String [] rsp = {"가위", "바위", "보"};
		
		Random random = new Random();
		int rspInt = random.nextInt(3);
		
		System.out.print("당신의 이름을 입력해주세요: ");
		String name = sc.nextLine();
		
		String user;
		String computer = "";
		int result = 0;		// 지면 0, 비기면 1, 이기면 2
		int[] record = new int[3];
		
		for(;;) {
			System.out.print("가위바위보 : ");
			user = sc.nextLine();
			computer = rsp[rspInt];
			
			if(user.equals("가위")) {
				if (computer == "가위") {
					result = 1;
				} else if (computer == "바위") {
					result = 0;
				} else if (computer == "보") {
					result = 2;
				}
				record[result]++;
			} else if (user.equals("바위")) {
				if (rsp[rspInt] == "가위") {
					result = 2;
				} else if (rsp[rspInt] == "바위") {
					result = 1;
				} else if (rsp[rspInt] == "보") {
					result = 0;
				}
				record[result]++;
			} else if (user.equals("보")) {
				if (rsp[rspInt] == "가위") {
					result = 0;
				} else if (rsp[rspInt] == "바위") {
					result = 2;
				} else if (rsp[rspInt] == "보") {
					result = 1;
				}
				record[result]++;
			} else if (user.equals("exit")) {
				int turn = record[0] + record[1] + record[2];
				System.out.printf("%d전 %d승 %d무 %d패 \n", turn, record[2], record[1], record[0]);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
			System.out.printf("컴퓨터 : %s \n", computer);
			System.out.printf("%s : %s \n", name, user);
			switch(result) {
			case 0:
				System.out.println("졌습니다.");
				break;
			case 1:
				System.out.println("비겼습니다.");
				break;
			case 2:
				System.out.println("이겼습니다.");
			}
		}
		

	}

}
