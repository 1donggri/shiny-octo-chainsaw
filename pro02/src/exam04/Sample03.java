package exam04;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		// Scanner를 사용하여 사용자 입력을 받는다.
		// 입력 받은 값에 대해 산술연산, 비교연산을 수행하도록 만든다.
		
		/*
		 * 출력 형식
		 * 		첫 번째 값 입력 : 10
		 * 		두 번째 값 입력 : 15
		 * 		더하기 계산 결과 : 25
		 *		빼기 계산 결과 : -5
		 *		나누기 계산 결과 : 0.6667
		 *		나머지 계산 결과 : 10
		 *		
		 * 나누기 계산 결과는 실수 값으로 나오게 한다. 그리고 반드시 소수점 4번째 자리까지만 나오게 한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 값 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 값 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.printf("더하기 계산결과 : %d \n", num1 + num2);
		System.out.printf("빼기 계산결과 : %d \n", num1 - num2);
		System.out.printf("곱하기 계산결과 : %d \n", num1 * num2);
		System.out.printf("나누기 계산결과 : %.4f \n", (double)num1 / num2);
		System.out.printf("나머지 계산결과 : %d \n", num1 % num2);
		

	}

}
