import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

	ArrayList<Card> card;
	ArrayList<Integer> differenceInCards;
	
	Hand() {
		Dealer dealer=new Dealer(3);
		card=dealer.getHand(13);
		for(int i=0;i<card.size();i++)
		{
			System.out.println(card.get(i));
		}
		System.out.println("----");
		Arrays.sort(card.toArray());
		for(int i=0;i<card.size();i++)
		{
			System.out.println(card.get(i));
		}
		differenceInCards=new ArrayList<Integer>();

		/*card = new ArrayList<Card>();
		card.add(new Card(5));
		card.add(new Card(23));
		card.add(new Card(7));
		card.add(new Card(2));
		card.add(new Card(0));
		Card[] tmp = card.toArray(new Card[0]);
		System.out.println(Arrays.deepToString(tmp));
		Arrays.sort(tmp);
		System.out.println(Arrays.deepToString(tmp));
		
		*/
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
