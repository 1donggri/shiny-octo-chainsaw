package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Sample10 {

	public static void main(String[] args) {
		/*
		 * 사용자로 부터 임의의 정수 값을 입력 받고 입력 받은 모든 정수의 합과 평균을 구하는
		 * 코드를 작성한다. (동적 배열 활용)
		 * 
		 * -1 입력이 들어오면 종료라고 판별한다.
		 * 
		 * 예제
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 		4 번째 정수값 입력 : -1
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int sum = 0;	double avr = 0;
		int[] a1 = new int[0];
		
		for(;;) {
			i++;
			System.out.printf("%d 번째 정수값 입력 : ", i);
			int user = sc.nextInt();
			
			int[] temp = Arrays.copyOf(a1, a1.length + 1);
			a1 = temp;
			
			if(user != -1) {
				a1[i - 1] = user;
			} else {
				for(i = 0; i < a1.length; i++) {
					sum += a1[i];
				}
				avr = (double)sum/(i-1);
				System.out.print("\n");
				System.out.printf("총 합 : %d \n", sum);
				System.out.printf("평 균 : %.1f \n", avr);
				break;
			}
		}

	}

}
