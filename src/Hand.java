import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

	ArrayList<Card> card;
	ArrayList<Integer> differenceInCards;
	
	Hand() {
		Dealer dealer=new Dealer(3);
		card=(ArrayList<Card>) dealer.getHand(13);
		Arrays.sort(card.toArray());		
	}
	
	void subtract() {
		for (int i=0;i<card.size()-1;i++) {
		differenceInCards.add(card.get(i+1).compareTo(card.get(i)));
		System.out.println(differenceInCards.get(i));
		}
	}
	
	public static void main(String args[])
	{
		Hand hand=new Hand();
		hand.subtract();
	}
}
