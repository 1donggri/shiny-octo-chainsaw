package exam02;

import java.util.Arrays;
import java.util.Random;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * 1 ~ 16 까지의 정수를 4x4 배열에 순차적으로 저장될 수 있게 하시오.
		 */
		
		int [][] a1 = new int [4][4];
		int init = 1;
		
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < a1[i].length; j++) {
				a1[i][j] = init++;
			}
		}
		
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < a1[i].length; j++) {
				System.out.print(a1[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
		System.out.println("-------------------------- \n");
		
		/*
		 * 1 ~ 49 사이의 임의의 정수를 5x6 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 */
		
		Random rand = new Random();
		int [][] a2 = new int [5][6];
		
		init = 1;
		
		for(int i = 0; i < a2.length; i++) {
			for(int j = 0; j < a2[i].length; j++) {
				a2[i][j] = rand.nextInt(49) + 1;
			}
		}
		
		for(int i = 0; i < a2.length; i++) {
			for(int j = 0; j < a2[i].length; j++) {
				System.out.print(a2[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
		System.out.println("-------------------------- \n");
		
		/*
		 * 1 ~ 49 사이의 임의의 정수를 5xN 배열에 순차적으로 저장하고 표 형식으로 출력하시오.
		 * (N의 경우 3 ~ 6 사이의 임의의 크기로 만들어 저장되도록 한다. <- 가변 길이 2차 배열)
		 */
		
		int [][] a3 = new int [5][];
		
		init = 1;
		
		for(int i = 0; i < a3.length; i++) {
			a3[i] = new int[rand.nextInt(4) + 3];
			
			for(int j = 0; j < a3[i].length; j++) {
				a3[i][j] = rand.nextInt(49) + 1;
			}
		}
		
		for(int i = 0; i < a3.length; i++) {
			for(int j = 0; j < a3[i].length; j++) {
				System.out.print(a3[i][j] + "\t");
			}
			System.out.println("\n");
		} 

	}

}
