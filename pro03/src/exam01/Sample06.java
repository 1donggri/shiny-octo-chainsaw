package exam01;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		
		switch(m) {
			case 1:
			case 2:
			case 3:
				System.out.println("1, 2, 3 중 하나를 입력 했습니다.");
				break;
				
			case 4:
			case 5:
			case 6:
				System.out.println("4, 5, 6 중 하나를 입력 했습니다.");
				break;
				
			case 7:
			case 8:
			case 9:
				System.out.println("7, 8, 9 중 하나를 입력 했습니다.");
		}
		

	}

}
