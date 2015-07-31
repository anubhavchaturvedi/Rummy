
public class Card implements Comparable<Card>{

	String representation;
	CardName name;
	Suite suite;
	
	@Override
	public String toString() {
		if ( name == CardName.JOKER ) {
			return "JJ";
		}
		
		return suite.toString() + name.toString();
	}
	
	@Override
	public int hashCode() {
		if ( name == CardName.JOKER ) {
			return 0;
		}
		
		return ( suite.value() * 13 ) + name.value();
	}
	
	@Override
	public int compareTo(Card card) {
		return this.hashCode() - card.hashCode();
	}
}
