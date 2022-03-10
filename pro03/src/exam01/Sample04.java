package exam01;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * Scanner 를 사용하여 사용자 입력을 받고 다음의 결과가 나오도록 하시오.
		 * 		1. 사용자 입력을 통해 국어, 영어, 수학 점수를 입력 받는다. (점수 데이터를 입력 받는다.)
		 * 		2. 입력 받은 점수 데이터의 값에 대해 총점과 평균을 구한다.
		 * 		3. 평균 점수가 60점 이상인 경우에만 다음의 메시지를 출력한다.
		 * 			축하 합니다. 합격입니다.
		 * 				총점: 213 점
		 * 				국어: 75 점
		 * 				영어: 70 점
		 * 				수학: 68 점
		 * 				평균: 71.0 점
		 * 		4. 평균 점수가 60점 미만인 경우에는 다음의 메시지를 출력한다.
		 * 			평균 점수가 미달하였습니다.
		 * 		5. 국어, 영어, 수학 과목 중 40점 미만의 과목이 있는 경우 다음의 메시지를 출력한다.
		 * 			과락된 과목이 있어 불합격 되었습니다.
		 */
		
		int kor, eng, mat, num1;
		double num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수 입력 : ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수 입력 : ");
		mat = sc.nextInt();
		
		num1 = kor + eng + mat;
		num2 = num1 / 3;
		
	
		if (kor < 40 || eng < 40 || mat < 40) {
			System.out.println("과락된 과목이 있어 불합격 되었습니다.");
			System.out.println("과락된 과목은 다음과 같습니다.");
			if (kor < 40) {
				System.out.println("국어");
			}
			if (eng < 40) {
				System.out.println("영어");
			}
			if (mat < 40) {
				System.out.println("수학");
			}
		} else {
			if (num2 >= 60) {
				System.out.println("축하 합니다. 합격입니다.");
				System.out.printf("총점: %d 점 \n국어: %d 점 \n영어: %d 점 \n수학: %d 점 \n평균: %.1f 점", num1, kor, eng, mat, num2);	
			} else {
				System.out.println("평균 점수가 미달하였습니다.");
			}
		}

	}

}
