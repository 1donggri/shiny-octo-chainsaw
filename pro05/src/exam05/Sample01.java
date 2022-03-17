package exam05;

import java.util.*;

public class Sample01 {

	public static void main(String[] args) {
		
		//
		Circle ci1 = new Circle();
		Circle ci2 = new Circle();
		
		ci1.radius = 1.5;	ci2.radius = 3.5;
		
		ci1.diamiter = ci1.radius * 2;
		ci2.diamiter = ci2.radius * 2;
		
		ci1.area = ci1.radius * ci1.radius * Circle.PI;
		ci2.area = ci2.radius * ci2.radius * Circle.PI;
		
		System.out.printf("ci1 인스턴스 정보 : 반지름(%.2f), 지름(%.2f), 넓이(%.2f)\n", ci1.radius, ci1.diamiter, ci1.area);
		System.out.printf("ci1 인스턴스 정보 : 반지름(%.2f), 지름(%.2f), 넓이(%.2f)\n", ci1.radius, ci1.diamiter, ci1.area);
		
		//
		Rectangle re1 = new Rectangle();
		Rectangle re2 = new Rectangle();
		
		re1.width = ci1.diamiter;
		re2.width = ci2.diamiter;
		
		Random rand = new Random();
		
		re1.height = rand.nextInt(7) + 3;
		re2.height = rand.nextInt(7) + 3;
		
		re1.area = re1.width * re1.height;
		re2.area = re2.width * re2.height;
		
		System.out.printf("re1 인스턴스 정보 : 너비(%.2f), 높이(%.2f), 넓이(%.2f)\n", re1.width, re1.height, re1.area);
		System.out.printf("re2 인스턴스 정보 : 너비(%.2f), 높이(%.2f), 넓이(%.2f)\n", re2.width, re2.height, re2.area);
	}
	
	/*
	 * 사물을 추상화하여 클래스(객체)를 만드는 과정
	 * 		1. 사물이 가지는 속성과 기능을 분류한다.
	 * 		2. 분류된 속성과 기능 중 프로그램에 필요한 속성과 기능만 재분류한다.
	 * 			예) 쇼핑몰용 회원 정보 관리에 필요한 사람정보
	 * 				대학교 학생 정보 관리에 필요한 사람정보
	 * 				회사 직원 정보 관리에 필요한 사람정보
	 * 		3. 재분류한 속성 및 기능만을 정의한 클래스 다이어그램을 만든다.
	 * 		4. 클래스 다이어그램을 참고하여 클래스를 만든다.
	 */

}
