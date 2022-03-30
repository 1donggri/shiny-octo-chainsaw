package exam07;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Employee e1 = new Level1("김사원", 28);
		Employee e2 = new Level2("박대리", 32);
		Employee e3 = new Level3("이과장", 38);
		Employee e4 = new Level4("차차장", 43);
		Employee e5 = new Level5("곽부장", 48);
		
//		e1.payMonth();	e1.bonus();
//		e2.payMonth();	e2.bonus();	((Level2)e2).card(460000);
//		e3.payMonth();	e3.bonus();	((Level3)e3).card(610000);
//		e4.payMonth();	e4.bonus();	((Level4)e4).card(826000);
//		e5.payMonth();	e5.bonus();	((Level5)e5).card(1300000);
		
		Employee[] empArr = new Employee[5];
		empArr[0] = e1;	empArr[1] = e2;	empArr[2] = e3;
		empArr[3] = e4;	empArr[4] = e5;
		
		Random rand = new Random();
		
		int year = 2022;
		for(int i = 0; i < 30; i++) {
			int month = (i + 1) % 12 == 0 ? 12 : (i + 1) % 12;
			for(int idx = 0; idx < empArr.length; idx++) {
				System.out.printf("%d년 %d월 급여명세 \n", year + (i + 1) / 12, month);
				System.out.printf("이름 : %s \n", empArr[idx].getName());
				empArr[idx].payMonth();
				empArr[idx].bonus(month);
				System.out.println("===========================");
			}
			if((rand.nextInt(9) + 1) % 4 == 0) {
				int loc = rand.nextInt(4) + 1;
				System.out.printf("%s 님이 ", empArr[loc].getName());
				((Level2)empArr[loc]).card(300000);
			}
		}
		
	}

}
