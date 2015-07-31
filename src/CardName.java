
public enum CardName {
	JOKER (0),
	ACE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10),
	JACK (11),
	QUEEN (12), 
	KING (13);
	
	private final int cardRank;
	
	private CardName(int cardRank) {
		this.cardRank = cardRank;
	}
	
	public int value() {
		return cardRank;
	}
	
	@Override
	public String toString(){
		switch(this) {
			case ACE : return "A";
			case TWO : return "2";
			case THREE : return "3";
			case FOUR : return "4";
			case FIVE : return "5";
			case SIX : return "6";
			case SEVEN : return "7";
			case EIGHT : return "8";
			case NINE : return "9";
			case TEN : return "T";
			case JACK : return "J";
			case QUEEN : return "Q";
			case KING : return "K";
			case JOKER : return "JJ";
			default : return "";
		}
	}
}
