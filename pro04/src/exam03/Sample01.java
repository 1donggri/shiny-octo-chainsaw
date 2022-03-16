package exam03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
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
		
		// 사용자 입력을 통해 문자열을 받아야 함.
		System.out.print("영문자 입력 : ");
		String user = sc.nextLine();
		
		// 문자열에서 문자 추출
		char [] ch = user.toCharArray();
		
		// 알파벳 수를 세기 위한 배열, 26개 공간이 있는 배열
		int [] az = new int [26];
		
		// 대소문자를 구분하지 않기 위한 방법
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
