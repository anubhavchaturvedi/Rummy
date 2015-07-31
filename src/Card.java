import java.util.Comparator;

public class Card implements Comparable<Card> {

	private CardName name;
	private Suite suite;
	public static Comparator<Card> sortUsingRank;

	public Card(CardName cardname, Suite suite) {
		this.name = cardname;
		this.suite = suite;
	}

	public Card(int cardId) {
		if (cardId == 0) {
			this.suite = Suite.JOKER;
			this.name = CardName.JOKER;
			return;
		}

		cardId = (cardId % 53) - 1;

		int suiteId = cardId / 13;
		int cardRank = (cardId % 13) + 1;
		for (CardName name : CardName.values()) {
			if (name.value() == cardRank) {
				this.name = name;
				break;
			}
		}

		for (Suite suite : Suite.values()) {
			if (suite.value() == suiteId) {
				this.suite = suite;
				break;
			}
		}

		sortUsingRank = new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				// TODO Auto-generated method stub
				return c1.getRank() - c2.getRank();
			}
		};
	}

	public static Card cardFromString(String representation) {
		String suite = representation.substring(0, 1);
		String name = representation.substring(1, 2);

		if (suite == "J")
			return new Card(0);

		Suite enum_suite = Suite.JOKER;
		CardName enum_name = CardName.JOKER;
		for (Suite s : Suite.values()) {
			if (s.toString().equals(suite))
				enum_suite = s;
		}

		for (CardName c : CardName.values()) {
			if (c.toString().equals(name)) {
				enum_name = c;
			}
		}

		return new Card(enum_name, enum_suite);
	}

	public Suite suite() {
		return this.suite;
	}

	public CardName name() {
		return this.name;
	}

	public int cardId() {
		if (name == CardName.JOKER) {
			return 0;
		}

		return (suite.value() * 13) + name.value();
	}

	@Override
	public String toString() {
		return name == CardName.JOKER ? name.toString() : suite.toString() + name.toString();
	}

	@Override
	public int hashCode() {
		return cardId();
	}

	@Override
	public int compareTo(Card card) {
		return this.cardId() - card.cardId();
	}

	public int getRank() {
		return this.name.value();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Card && (((Card) obj).cardId() == this.cardId());
	}
}
