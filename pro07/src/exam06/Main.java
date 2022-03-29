package exam06;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		/*
		 * 다형성 / 업캐스팅 / 다운캐스팅 활용
		 * 		- 일반 고객 5명을 생성한다.(이름, 나이, 성별 초기화 하지 않아도 됨)
		 * 		- 일반 고객 5명을 배열에 넣어 랜덤한 고객, 랜덤한 가격으로 물품을 구입하게 만든다.
		 * 		- 물품 구입액이 1,000,000 원을 초과하면 프리미엄 고객으로 전환시켜서 물품 구입에 할인율을
		 * 		  적용할 수 있도록 만든다.
		 * 		- 고객이 물품을 구입하는 작업을 반복문을 통해 반복하게 만드며, 100번 반복하게 만든다.
		 * 
		 * 일반 고객 -> 프리미엄 고객 전환
		 * 		Nomal n1 = new Nomal("홍길동");
		 * 		Premium p1 = new Premium();
		 * 		p1.setName(n1.getName); 
		 */
		
		Random rand = new Random();
		Customer [] cus = new Customer[5];
		
		for(int i = 0; i < cus.length; i++) {
			cus[i] = new Nomal();
		}
		
		for(int i = 0; i < 100; i++) {
			int c = rand.nextInt(cus.length);
			int p = rand.nextInt(1000000) + 10000;
			cus[c].buy("물품", p);
			
			if(cus[c] instanceof Nomal) {
				int dis = 0;
				Nomal nom = (Nomal) cus[c];
				nom.buy("물품", p);
			
				if(p > 1000000) {
					Premium pre = new Premium();
					pre.setName(cus[c].getName());
					pre.setAge(cus[c].getAge());
					pre.setGender(cus[c].getGender());
					pre.setAmount(p);
					cus[c] = pre;
					System.out.println("축하합니다. 구입액이 1,000,000원을 초과하여 프리미엄 등급으로 상승하였습니다.");
					System.out.println("앞으로 물품 구입 누적액에 따른 할인율이 적용됩니다.");
				}
			} else {
				Premium pre = (Premium) cus[c];
				pre.buy("물품", p);
			}
		}
		
		
	}

}
