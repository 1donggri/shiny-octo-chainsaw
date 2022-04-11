package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.record.Record;

public class Complayer implements Player {
	
	Random rand = new Random();
	private Hand h;
	
	@Override
	public void randomCardHand() {
		int num = rand.nextInt(3);
		if(num == 0) {
			h = new Gawi();
			System.out.println("컴퓨터 : 가위");
		} else if(num == 1) {
			h = new Bawi();
			System.out.println("컴퓨터 : 바위");
		} else if(num == 2) {
			h = new Bo();
			System.out.println("컴퓨터 : 보");
		}
	}

	@Override
	public String versus(Hand oh) {
		// 가위, 바위, 보 대결을 진행한다.
		String result = "";
		
		if(h.capare(oh) == 1) {
			result = "승";
		} else if(h.capare(oh) == -1){
			result = "패";
		} else if(h.capare(oh) == 0) {
			result = "무";
		}
		
		return result;
	}

	public Hand getHand() {
		return h;
	}

	public void setHand(Hand h) {
		this.h = h;
	}
}
