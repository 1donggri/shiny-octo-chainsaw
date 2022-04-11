package game.card;

public class Gawi extends Hand {

	@Override
	public int capare(Hand otherHand) {
		int res = -2;
		if(otherHand instanceof Gawi) {
			res = 0;
		} else if(otherHand instanceof Bawi) {
			res = -1;
		} else if(otherHand instanceof Bo) {
			res = 1;
		}
		return res;
	}

	@Override
	public Hand cheat(Hand otherHand) {
		Hand newHand = null;
		
		if(otherHand instanceof Gawi) {
			newHand = new Bawi();
		} else if(otherHand instanceof Bawi) {
			newHand = new Bo();
		} else if(otherHand instanceof Bo) {
			newHand = new Gawi();
		}
		
		return newHand;
	}

}
