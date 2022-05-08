package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 * 		- 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 * 		- 중복된 값이 없어야 한다.
		 * 		- 총 6개의 정수값이 리스트에 담길 수 있게 한다.
		 * 		- 마지막에 출력할 때에는 오름차순으로 정렬하여 출력한다.
		 */
		
		Random rand = new Random();
		
		List<Integer> lottoList = new ArrayList<Integer>();
		
		while(true) {
			int num = rand.nextInt(45) + 1;
			
			if(!lottoList.contains(Integer.valueOf(num))) {
				lottoList.add(num);
			}
			
			if(lottoList.size() == 6) {
				Collections.sort(lottoList);
				for(int i = 0; i < lottoList.size(); i++) {
					System.out.print(lottoList.get(i) + "\t");
				}
				break;
			}
		}
		
		

	}

}
