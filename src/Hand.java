import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	ArrayList<Card> card;
	ArrayList<Integer> differenceInCards;
	
	Hand() {
		Dealer dealer=new Dealer(3);
		card=dealer.getHand(13);
		Collections.sort(card);		
		differenceInCards=new ArrayList<Integer>();

	}
	
	void subtract() {
		for (int i=0;i<card.size()-1;i++) {
		differenceInCards.add(card.get(i+1).compareTo(card.get(i)));
		}
	}
}
