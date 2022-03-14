package exam01;

import java.util.Random;
import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 가위 바위 보 게임에서 컴퓨터 어쩌공
		 */
		
		Random rand = new Random();
		String[] convert = {"가위", "바위", "보"};
		String sCom = "";
		int res = rand.nextInt(3);
		
		System.out.println("컴퓨터 : " + convert[res]);

	}

}
