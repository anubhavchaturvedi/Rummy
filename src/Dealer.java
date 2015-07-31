
public class Dealer {
	private int[] deck;
	private final int CARDS_IN_PACK = 53;
	
	public Dealer(int numberOfPack) {
		int totalCards = CARDS_IN_PACK * numberOfPack;
		deck = new int[totalCards];
		for(int i = 0; i < totalCards; i++) {
			deck[i] = i % CARDS_IN_PACK;
		}
	}
}
