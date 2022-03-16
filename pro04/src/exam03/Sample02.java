package exam03;

import java.util.Arrays;
import java.util.Random;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 1. 배열의 크기가 10 인 정수 배열을 2개 생성 후 각 배열에 10 ~ 99 사이의
		 * 		난수값으로 초기화 시키고 출력한다.
		 */
		
		Random rand = new Random();
		
		// 배열 생성
		int [] a1 = new int [10];
		int [] a2 = new int [10];
		
		// 초기화
		for(int i = 0; i < a1.length; i++) {
			a1[i] = rand.nextInt(90) + 10;
		}
		
		for(int i = 0; i < a2.length; i++) {
			a2[i] = rand.nextInt(90) + 10;
		}
		
		// 출력
		System.out.println("1. 결과 확인");
		System.out.println("\t" + Arrays.toString(a1));
		System.out.println("\t" + Arrays.toString(a2));
		System.out.print("\n");
		
		/*
		 * 2. 1번 문제에서 생성한 첫번째 배열과 두번째 배열의 합을 구하여 새로운 세번째 배열을
		 * 		만들고 출력한다.
		 */
		
		// 
		int [] a3 = new int[10];
		
		//
		for(int i = 0; i < a3.length; i++) {
			a3[i] = a1[i] + a2[i];
		}
		
		//
		System.out.println("2. 결과 확인");
		System.out.println("\t" + Arrays.toString(a3));
		System.out.print("\n");
		
		/*
		 * 3. 2번 문제까지 진행하여 만들어진 3개의 배열을 이용하여 짝수값만 저장되어 있는 배열과
		 * 		홀수값만 저장되어 있는 배열을 만들고 짝수 배열과 홀수 배열을 출력한다.
		 */
		
		//
		int [] en1 = new int [0];
		int [] on1 = new int [0];
		
		//
		for(int i = 0; i < a1.length; i++) {
			if(a1[i] % 2 == 0) {
				int [] temp = Arrays.copyOf(en1, en1.length + 1);
				en1 = temp;
				en1[en1.length - 1] = a1[i];
			} else {
				int [] temp = Arrays.copyOf(on1, on1.length + 1);
				on1 = temp;
				on1[on1.length - 1] = a1[i];
			}
		}
		
		for(int i = 0; i < a2.length; i++) {
			if(a2[i] % 2 == 0) {
				int [] temp = Arrays.copyOf(en1, en1.length + 1);
				en1 = temp;
				en1[en1.length - 1] = a2[i];
			} else {
				int [] temp = Arrays.copyOf(on1, on1.length + 1);
				on1 = temp;
				on1[on1.length - 1] = a2[i];
			}
		}
		
		for(int i = 0; i < a3.length; i++) {
			if(a3[i] % 2 == 0) {
				int [] temp = Arrays.copyOf(en1, en1.length + 1);
				en1 = temp;
				en1[en1.length - 1] = a3[i];
			} else {
				int [] temp = Arrays.copyOf(on1, on1.length + 1);
				on1 = temp;
				on1[on1.length - 1] = a3[i];
			}
		}
		
		// 출력
		System.out.println("3. 결과 확인");
		System.out.println("\t" + Arrays.toString(en1));
		System.out.println("\t" + Arrays.toString(on1));
		System.out.print("\n");
		
		/*
		 * 4. 짝수/홀수 배열에 있는 값들중 중복된 값이 있는 경우 하나의 값만 남겨 새로운 배열로
		 * 		만들고 출력 한다.
		 */
		
		int [] en2 = new int [1];
		int [] on2 = new int [1];
		
		int idx1 = 0;	int idx2 = 0;
		
		en2[0] = en1[0];
		for(int i = 1; i < en1.length; i++) {
			int temp = en1[i];
			boolean dup = false;
			for(int j = 0; j < en2.length; j++) {
				if(en2[j] == temp) {
					dup = true;
					break;
				}
			}
			if(!dup) {
				en2 = Arrays.copyOf(en2, en2.length + 1);
				en2[en2.length - 1] = temp;
			}	
		}
		
		on2[0] = on1[0];
		for(int i = 1; i < on1.length; i++) {
			int temp = on1[i];
			boolean dup = false;
			for(int j = 0; j < on2.length; j++) {
				if(on2[j] == temp) {
					dup = true;
					break;
				}
			}
			if(!dup) {
				on2 = Arrays.copyOf(on2, on2.length + 1);
				on2[on2.length - 1] = temp;
			}	
		}
		
		
//		for(int i = 0; i < en1.length; i++) {
//			for(int j = i; j < en1.length; j++) {
//				if(i != j) {
//					if(en1[j] != -1) {
//						if(en1[i] == en1[j]) {
//							en1[j] = -1;
//						}
//					}
//				}
//			}
//			int[] temp;
//			if(en1[i] != -1) {
//				temp = new int[en2.length + 1];
//				System.arraycopy(en2, 0, temp, 0, en2.length);
//				en2 = temp;
//				en2[idx1] = en1[i];
//				idx1++;
//			}
//		}
		
//		for(int i = 0; i < on1.length; i++) {
//			for(int j = i; j < on1.length; j++) {
//				if(i != j) {
//					if(on1[j] != -1) {
//						if(on1[i] == on1[j]) {
//							on1[j] = -1;
//						}
//					}
//				}
//			}
//			int[] temp;
//			if(on1[i] != -1) {
//				temp = new int[on2.length + 1];
//				System.arraycopy(on2, 0, temp, 0, on2.length);
//				on2 = temp;
//				on2[idx2] = on1[i];
//				idx2++;
//			}
//		}
		
		// 출력
		System.out.println("4. 결과 확인");
		System.out.println("\t" + Arrays.toString(en2));
		System.out.println("\t" + Arrays.toString(on2));
		System.out.print("\n");
		
		
		/*
		 * 5. 짝수/홀수 배열에 있는 값을 작은값 부터 큰값 순으로 정렬된 배열을 만들고 출력한다.
		 */
		
		int [] en3 = en2.clone();
		int [] on3 = on2.clone();
		
		for(int i = 0; i < en3.length - 1; i++) {
			for(int j = i + 1; j < en3.length; j++) {
				if(en3[i] > en3[j]) {
					int temp = en3[i];
					en3[i] = en3[j];
					en3[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < on3.length - 1; i++) {
			for(int j = i + 1; j < on3.length; j++) {
				if(on3[i] > on3[j]) {
					int temp = on3[i];
					on3[i] = on3[j];
					on3[j] = temp;
				}
			}
		}
		
		// 출력
		System.out.println("5. 결과 확인");
		System.out.println("\t" + Arrays.toString(en3));
		System.out.println("\t" + Arrays.toString(on3));
		System.out.print("\n");
		
		/*
		 * 6. 짝수/홀수 배열로 나누어져 있는 것을 하나의 배열로 합쳐서 하나의 배열로 만들고 출력한다.
		 */
		
		int [] a4 = new int [en3.length + on3.length];
		
		System.arraycopy(en3, 0, a4, 0, en3.length);
		System.arraycopy(on3, 0, a4, en3.length, on3.length);
		
		// 출력
		System.out.println("6. 결과 확인");
		System.out.println("\t" + Arrays.toString(a4));
		System.out.print("\n");
		
	}

}
