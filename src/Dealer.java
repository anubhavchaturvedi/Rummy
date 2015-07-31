import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	private ArrayList<Card> deck;
	private final int CARDS_IN_PACK = 53;

	public Dealer(int numberOfPack) {
		deck = new ArrayList<Card>(CARDS_IN_PACK * numberOfPack);
		for (int i = 0; i < numberOfPack; i++) {
			for ( int j = 0; j < CARDS_IN_PACK; j++ )
				deck.add(new Card(j));
		}
	}

	public ArrayList<Card> getHand(int size) {
		Collections.shuffle(deck);
		return new ArrayList<Card>(deck.subList(0, size));
	}
}
