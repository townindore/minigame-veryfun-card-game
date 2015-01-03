/**
 * From Java How to Program Deitel and Deitel
 * @author Deitel and Deitel
 * EDITED BY TANG YINGDUO JP093090
 */

class Card {
	private String face;
	private String suit;

	// constructor to initialize a card
	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}

} // end class Card
