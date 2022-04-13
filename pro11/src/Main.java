import java.util.Scanner;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.db.Database;
import game.player.Complayer;
import game.player.Player;
import game.player.UserPlayer;
import game.record.Record;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserPlayer user = new UserPlayer();
		Complayer com = new Complayer();
		Record r = new Record();
		Database db = new Database();
		
		int[] record = db.load();
		
		while(true) {
			System.out.print("가위 바위 보 중 하나를 입력하세요.\n");
			System.out.print("아무 값도 입력하지 않고 Enter 키를 누르거나 입력 값이 틀린 경우\n");
			System.out.print("임의의 값으로 진행 됩니다.\n");
			System.out.print("종료를 원하는 경우 \"종료\"라고 입력하세요.\n");
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			user.setRecordArray(record);
			
			if(input.equals("종료")) {
				System.out.println("게임을 종료 합니다.");
				System.out.println("현재 까지 진행 사항을 저장합니다.");
				System.out.printf("%d전 %d승 %d패 %d무 \n", r.getRecordCount(), r.getScore()[0], r.getScore()[1], r.getScore()[2]);
				System.out.printf("승률 : %f", r.getWinRate());
				db.save(user.getRecordArray());
				break;
			} else {
				user.setHand(input);
				com.randomCardHand();
				
				String result = user.versus(com.getHand());
				System.out.println("결과 : " + result);
			}
			
		}

	}

}
 