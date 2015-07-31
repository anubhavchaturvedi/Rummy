
public enum Suite {
	JOKER (-1),
	SPADE (0),
	CLUB (1), 
	HEART (2), 
	DIAMOND (3);
	
	private int suiteId;
	
	private Suite(int suiteId) {
		this.suiteId = suiteId;
	}
	
	int value() {
		return suiteId;
	}
	
	@Override
	public String toString() {
		switch (this){
		case SPADE : return "S";
		case CLUB : return "C";
		case HEART : return "H";
		case DIAMOND : return "D";
		case JOKER : return "";
		default : return "";
		}
	}
}
