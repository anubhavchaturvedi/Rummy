
public enum Suite {
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
}
