package exam04;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * 섭씨 화씨 변환
		 * 		사용자 입력으로 섭씨 값을 받는다. (정수 값만 입력받는다.)
		 * 		입력받은 섭씨를 화씨 변환하여 출력 (실수 결과로 출력한다.)
		 * 
		 * 섭씨 -> 화씨 변환 식
		 * 		(섭씨 * (9 / 5)) + 32 = 화씨
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 값 입력 : ");
		int num1 = sc.nextInt();
		
		double num2 = (num1 * 9.0 / 5.0) + 32;
		
		System.out.printf("화씨 값은 %.2f℉ 입니다.", num2);
		
	}

}
