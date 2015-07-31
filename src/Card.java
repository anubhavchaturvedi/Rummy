
public class Card implements Comparable<Card>{

	CardName name;
	Suite suite;
	
	public Card(CardName cardname, Suite suite){
		this.name = cardname;
		this.suite = suite;
	}
	
	public Card(int cardId) {
		if ( cardId == 0 ) {
			this.suite = Suite.JOKER;
			this.name = CardName.JOKER;
			return;
		}
		
		cardId = ( cardId % 53 ) - 1;
		
		int suiteId = cardId / 13;
		int cardRank = ( cardId % 13 ) + 1;
		for ( CardName name : CardName.values() ) {
			if ( name.value() == cardRank ) {
				this.name = name;
				break;
			}
		}
		
		for ( Suite suite : Suite.values() ) {
			if ( suite.value() == suiteId ) {
				this.suite = suite;
				break;
			}
		}
	}
	
	public int cardId(){
		if ( name == CardName.JOKER ) {
			return 0;
		}
		
		return ( suite.value() * 13 ) + name.value();
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
}
