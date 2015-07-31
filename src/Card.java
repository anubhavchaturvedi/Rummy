
public class Card implements Comparable<Card>{

	String representation;
	CardName name;
	Suite suite;
	
	public Card(CardName cardname, Suite suite){
		this.name = cardname;
		this.suite = suite;
	}
	
	public Card(int cardId) {
		int suiteId = cardId / 13;
		int cardRank = cardId % 13;
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
		if ( name == CardName.JOKER ) {
			return "JJ";
		}
		
		return suite.toString() + name.toString();
	}
	
	@Override
	public int hashCode() {
		return cardId();
	}
	
	@Override
	public int compareTo(Card card) {
		return this.hashCode() - card.hashCode();
	}
}
