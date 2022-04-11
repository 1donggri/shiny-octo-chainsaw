package game;

import java.util.Random;

import result.Correct;
import result.Down;
import result.Fail;
import result.ResultValue;
import result.Up;

public class GuessNum {
	
	private int num;
	private int count;
	
	public GuessNum() {
		Random rand = new Random();
		this.num = rand.nextInt(100) + 1;
		this.count = 10;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public ResultValue guess(int num) {
		ResultValue v = new Fail();
		
		count--;
		
		if(this.num == num) {
			v = new Correct();
		} else {
			if(count == 0) {
				v = new Fail();
			} else if(this.num > num) {
				v = new Up();
			} else if(this.num < num) {
				v = new Down();
			}
		}
		
		return v;
	}
	
	public boolean remainCount() {
		return this.count > 0 ? true : false;
	}
	
	

}
