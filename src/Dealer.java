import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	private List<Integer> deck;
	private final int CARDS_IN_PACK = 53;

	public Dealer(int numberOfPack) {
		int totalCards = CARDS_IN_PACK * numberOfPack;
		deck = new ArrayList<Integer>();
		for (int i = 0; i < totalCards; i++) {
			deck.add(i % CARDS_IN_PACK);
		}
	}

	public List<Integer> getHand(int length) {
		Collections.shuffle(deck);
		return deck.subList(0, length);
	}
}
