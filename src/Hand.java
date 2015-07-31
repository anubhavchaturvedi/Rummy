import java.util.Arrays;

public class Hand {

	Card card[];
	
	Hand() {
		Dealer dealer=new Dealer();
		card=dealer.getCards(13);
		Arrays.sort(card);
	}
	
}
