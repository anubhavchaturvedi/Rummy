import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	private List<Card> deck;
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
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < length; i++) {
			hand.add(deck.get(i));
		}
		return hand;
	}
}
