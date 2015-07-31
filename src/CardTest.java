import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest {

	@Test
	public void cardgeneration() {
		for ( int i = 0 ; i < (53 * 3); i++ ) {
			System.out.println( i + " -> " + new Card(i));
		}
		
		System.out.println((new Card(4)).equals((new Card(4))));
	}

}
