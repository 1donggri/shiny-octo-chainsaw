package exam02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Prec {

	public static void main(String[] args) {
		/*
		 * 1 ~ 16 까지의 정수를 4x4 배열에 순차적으로 저장될 수 있게 하시오.
		 */
		
		int [][] a1 = new int [4][4];
		int num = 1;
		
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < a1[i].length; j++) {
				a1[i][j] = num;
				num++;
			}
		}
		
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < a1[i].length; j++) {
				System.out.print(a1[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("-------------------------");
		
		/*
		 * 1 ~ 49 사이의 임의의 정수를 5x6 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 */
		
		int [][] a2 = new int [5][6];
		Random rand = new Random ();
		
		for(int i = 0; i < a2.length; i++) {
			for(int j = 0; j < a2[i].length; j++) {
				a2[i][j] = rand.nextInt(49) + 1;
			}
		}
		
		for(int i = 0; i < a2.length; i++) {
			for(int j = 0; j < a2[i].length; j++) {
				System.out.print(a2[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("-------------------------");
		
		/*
		 * 1 ~ 49 사이의 임의의 정수를 5xN 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 * (N의 경우 3 ~ 6 사이의 임의의 크기로 만들어 저장되도록 한다. <- 가변 길이 2차 배열)
		 */
		
		int [][] a3 = new int [5][];
		
		for(int i = 0; i < a3.length; i++) {
			a3[i] = new int [rand.nextInt(4) + 3];
			
			for(int j = 0; j < a3[i].length; j++) {
				a3[i][j] = rand.nextInt(49) + 1; 
				}
			}
		
		for(int i = 0; i < a3.length; i++) {
			for(int j = 0; j < a3[i].length; j++) {
				System.out.print(a3[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("-------------------------");
		
		/*
		 * 사용자가 입력한 영문자열에서 입력된 문자의 수를 구하는 코드를 작성
		 * 		1. 영문자를 제외한 다른 문자는 무시한다.
		 * 		2. 영문자의 대/소문자를 구분하지 않고 문자 수를 구한다.
		 * 
		 * 예제
		 * 		영문자 입력 : hello java programming
		 * 
		 * 		입력한 영문자 분포
		 * 		a(3), e(1), g(2), h(1), i(1),
		 * 		j(1), l(2), m(2), n(1), o(2),
		 * 		p(1), r(2), v(1)
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("영문자 입력 : ");
		String user = sc.nextLine();
		char [] ch = user.toCharArray();
		
		int [] az = new int [26];
		
		for(int i = 0; i < user.length(); i++) {
			if (ch[i] >= 65 && ch[i] <= 90) {
				az[ch[i] - 65]++;
			} else if (ch[i] >= 97 && ch[i] <= 122) {
				az[ch[i] - 97]++;
			}	
		}
		
		System.out.print("\n");
		System.out.println("입력한 영문자 분포");
		
		for(char i = 'a'; i < 'z'; i++) {
			if(az[i-97] > 0) {
				System.out.printf("%s(%d) ", i, az[i-97]);
			}
		}
		
		

	}

}
