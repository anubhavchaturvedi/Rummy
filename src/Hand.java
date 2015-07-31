public class Hand {

	Card card[];
	
	Hand() {
		Dealer dealer=new Dealer();
		card=dealer.getCards(13);
	}
	
}
