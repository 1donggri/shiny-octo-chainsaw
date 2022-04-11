package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.record.Record;

public class UserPlayer implements Player {
	
	Random rand = new Random();
	private Hand hand;
	private Record rec = new Record();

	@Override
	public void randomCardHand() {
		// 임의의 가위,바위,보가 반환되도록 한다.
		int num = rand.nextInt(3);
		if(num == 0) {
			hand = new Gawi();
		} else if(num == 1) {
			hand = new Bawi();
		} else if(num == 2) {
			hand = new Bo();
		}
	}

	@Override
	public String versus(Hand oh) {
		// 가위, 바위, 보 대결을 진행한다.
		String result = "";
		
		if(hand.capare(oh) == 1) {
			result = "승";	rec.addWin();
		} else if(hand.capare(oh) == -1){
			result = "패";	rec.addLose();
		} else if(hand.capare(oh) == 0) {
			result = "무";	rec.addDraw();
		}
		
		return result;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(String hand) {
		if(hand.equals("가위")) {
			this.hand = new Gawi();
		} else if(hand.equals("바위")) {
			this.hand = new Bawi();
		} else if(hand.equals("보")) {
			this.hand = new Bo();
		} else {
			this.randomCardHand();
		}
	}
	
	

}
