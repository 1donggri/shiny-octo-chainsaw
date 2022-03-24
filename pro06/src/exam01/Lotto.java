package exam01;

import java.util.Random;
import java.util.Arrays;

public class Lotto {
	
	private int rangeMin = 1;
	private int rangeMax = 45;
	private int count = 6;
	private int [] numbers;
	Random rand = new Random();
	
	public Lotto() {
		this.numbers = new int[count];
	}
	
	public Lotto(int min, int max, int count) {
		this.rangeMin = min;
		this.rangeMax = max;
		this.count = count;
		this.numbers = new int[count];
	}
	
	public void setRangeMin(int rangeMin) {
		this.rangeMin = rangeMin;
	}
	
	public void setRangeMax(int rangeMax) {
		this.rangeMax = rangeMax;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	// getter
	public int getRangeMin() {
		return rangeMin;
	}
	
	public int getRangeMax() {
		return rangeMax;
	}
	
	public int getCount() {
		return count;
	}
	
	public int[] getNumbers() {
		return numbers;
	}
		
	// 로또 번호 생성 : 중복체크 ..
	private boolean _isDuplicate(int number) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number) {
				return true;
			}
		}
		return false;
	}
	
	public void generate() {
		for(int i = 0; i < count;) {
			int num = this.rand.nextInt(rangeMax) + rangeMin;
			if(_isDuplicate(num) == false) {
				numbers[i] = num;
				i++;
			}
		}
	}
	
	public void generate(int ... nums) {
		int cnt = nums.length;
		
		for(int i = 0; i < cnt; i++) {
			numbers[i] = nums[i];
		}
		
		for(int i = 0; i < count;) {
			int num = this.rand.nextInt(rangeMax) + rangeMin;
			if(_isDuplicate(num) == false) {
				numbers[i] = num;
				i++;
			}
		}
	}
	
//	public void generate(int n1) {
//	numbers[0] = n1;
//	for(int i = 1; i < count; i++) {
//		numbers[i] = this.rand.nextInt(rangeMax) + rangeMin;
//	}
//}	
	
//	public void generate(int n1, int n2) {
//		numbers[0] = n1;	numbers[1] = n2;
//		for(int i = 2; i < count; i++) {
//			numbers[i] = this.rand.nextInt(rangeMax) + rangeMin;
//		}
//	}
	
//	public void generate(int n1, int n2, int n3) {
//		numbers[0] = n1;	numbers[1] = n2;
//		numbers[2] = n3;
//		for(int i = 3; i < count; i++) {
//			numbers[i] = this.rand.nextInt(rangeMax) + rangeMin;
//		}
//	}
	
//	public void generate(int n1, int n2, int n3, int n4) {
//		numbers[0] = n1;	numbers[1] = n2;
//		numbers[2] = n3;	numbers[3] = n4;
//		for(int i = 4; i < count; i++) {
//			numbers[i] = this.rand.nextInt(rangeMax) + rangeMin;
//		}
//	}
	
//	public void generate(int n1, int n2, int n3, int n4, int n5) {
//		numbers[0] = n1;	numbers[1] = n2;
//		numbers[2] = n3;	numbers[3] = n4;
//		numbers[4] = n5;
//		for(int i = 5; i < count; i++) {
//			numbers[i] = this.rand.nextInt(rangeMax) + rangeMin;
//		}
//	}

}
