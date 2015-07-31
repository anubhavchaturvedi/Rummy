import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand {

	ArrayList<Card> card;

	ArrayList<Card[]> finalSequences;

	Hand() {
		Dealer dealer = new Dealer(3);
		card = dealer.getHand(13);

		card.clear();
		String seq[] = "S6, SJ, C5, C5, C5, CT, CJ, H2, H6, D3, D4, D5, DQ".split(", ");
		for (String c : seq) {
			card.add(Card.cardFromString(c));
		}

		Collections.sort(card);
		Collections.sort(card, Card.sortUsingRank);
		finalSequences = new ArrayList<Card[]>();
	}

	ArrayList<Integer> findDifferenceInCards() {
		ArrayList<Integer> differenceInCards = new ArrayList<>();

		if (card.isEmpty())
			return differenceInCards;

		differenceInCards.add(-1);
		for (int i = 1; i < card.size(); i++) {
			if (card.get(i).suite() == card.get(i - 1).suite())
				differenceInCards.add(card.get(i).compareTo(card.get(i - 1)));
			else
				differenceInCards.add(-1);
		}
		return differenceInCards;
	}

	ArrayList<Card> hand() {
		return card;
	}

	ArrayList<Card[]> finalSequences() {
		return this.finalSequences;
	}

	String finalSequencesString() {
		String str = "";
		for (Card[] seq : finalSequences) {
			str += Arrays.deepToString(seq) + "  ";
		}
		return str;
	}

	private void extractKanasta() {
		extractSequence(3, 0);
	}

	private void extractPureSequence(int size) {
		extractSequence(size, 1);
	}

	private void extractSequence(int size, final int REQUIRED_DIFFERENCE) {
		ArrayList<Card[]> sequences = new ArrayList<>();
		ArrayList<Integer> differenceInCards = findDifferenceInCards();
		ArrayList<Card> cardsToRemove = new ArrayList<Card>();

		int continuousRequiredDifferenceCount = 0;
		for (int i = 0; i < differenceInCards.size(); i++) {
			int difference = differenceInCards.get(i);
			if (difference == REQUIRED_DIFFERENCE) {
				continuousRequiredDifferenceCount++;
			} else {
				continuousRequiredDifferenceCount = 0;
			}

			if (continuousRequiredDifferenceCount == (size - 1)) {
				Card[] seq = new Card[size];
				for (int j = (i - (size - 1)); j <= i; j++) {
					seq[j - (i - (size - 1))] = card.get(j);
					cardsToRemove.add(card.get(j));
				}
				sequences.add(seq);
				continuousRequiredDifferenceCount = 0;
			}
		}

		removeCards(cardsToRemove);
		addToFinalResult(sequences);
	}

	private void addToFinalResult(ArrayList<Card[]> sequences) {
		finalSequences.addAll(sequences);
	}

	private void removeCards(ArrayList<Card> cards) {
		for (Card card : cards) {
			this.card.remove(card);
		}
	}

	public static void main(String args[]) {
		// [SA, S3, S4, S5, C7, HA, H2, H3, H8, DA, D6, DJ, DK]
		// [S6, SJ, C5, C5, C5, CT, CJ, H2, H6, D3, D4, D5, DQ]
		Hand hand = new Hand();
		System.out.println("HAND :::: " + hand.hand());
		hand.extractKanasta();
		System.out.println("F_SEQ:::: " + hand.finalSequencesString());
		System.out.println("HAND :::: " + hand.hand());
		hand.extractPureSequence(4);
		hand.extractPureSequence(3);
		System.out.println("F_SEQ:::: " + hand.finalSequencesString());
		System.out.println("HAND :::: " + hand.hand());

		hand.extractPureSequence(2);
		hand.extractSequence(2, 0);
		hand.extractSequence(2, 2);
		System.out.println("F_SEQ:::: " + hand.finalSequencesString());
		System.out.println("HAND :::: " + hand.hand());
	}
}
