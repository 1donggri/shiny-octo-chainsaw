package exam01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sample08 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 5인 정수 배열을 생성하고 해당 배열에 1 ~ 19 까지의 정수 값을
		 * 임의로 생성하여 초기화 하는 작업을 수행하도록 한다.
		 * 단, 배열에 초기화된 값은 중복되어서는 안된다.
		 */
		
		int[] a1 = new int[5];
		Random rand = new Random();
		boolean dup = false;
		
		for(int i = 0; i < a1.length;) {
			int num = rand.nextInt(19) + 1;
			for(int j = 0; j < i; j++) {
				if(a1[j] == num) {
					dup = true;
					break;
				}
			}
			if(!dup) {
				a1[i] = num;
				i++;	dup = false;
			}
		}
		for(int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + "\t");
		}
		
		System.out.print("\n");
		System.out.println("-----------");
		
		/*
		 * 사용자로 부터 임의의 정수 값을 입력 받고 입력 받은 모든 정수의 합과 평균을 구하는
		 * 코드를 작성한다.
		 * 사용자로 부터 임의의 정수 값을 입력 받기 전에 총 몇개의 정수 값을 입력 받을지 확인 후
		 * 작업을 한다.
		 * 
		 * 예제
		 * 		총 입력 횟수 : 3
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 */
		
		int user, turn;
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("총 입력 횟수 : ");
		turn = sc.nextInt();
		
		int[] a2 = new int[turn];
		
		for(int i = 0; i < turn; i++) {
			System.out.printf("%d 번째 정수값 입력 : ", i+1);
			user = sc.nextInt();
			a2[i] = user;	sum += user;
		}
		
		System.out.print("\n");
		System.out.printf("총 합 : %d \n평 균 : %.1f", sum, (double)sum/turn);

	}

}
