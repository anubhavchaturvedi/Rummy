import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	private ArrayList<Card> deck;
	private final int CARDS_IN_PACK = 53;

	public Dealer(int numberOfPack) {
		int totalCards = CARDS_IN_PACK * numberOfPack;
		deck = new ArrayList<Card>();
		for (int i = 0; i < totalCards; i++) {
			deck.add(new Card());
		}
	}

	public ArrayList<Card> getHand(int length) {
		Collections.shuffle(deck);
		return new ArrayList<Card>(deck.subList(0, length));
	}
}
