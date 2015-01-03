/**
 * From Java How to Program Deitel and Deitel
 * @author Deitel and Deitel
 * EDITED BY TANG YINGDUO JP093090
 */

class Card {
	private String face;
	private String suit;
	public int faceValue;
	public int suitValue;

	// constructor to initialize a card
	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}
	
		
	//return value of the card
	public int faceToValue(){
	String faceName = this.face;
	if (faceName.equals("Ace"))return 1;
	else if (faceName.equals("Deuce"))return 2;
	else if (faceName.equals("Three"))return 3;
	else if (faceName.equals("Four"))return 4;
	else if (faceName.equals("Five"))return 5;
	else if (faceName.equals("Six"))return 6;
	else return 0;
	}
	
	public int suitToValue(){
	String suitName = this.suit;
	if (suitName.equals("Hearts"))return 1;
	else if (suitName.equals("Diamonds"))return 2;
	else if (suitName.equals("Clubs"))return 3;
	else if (suitName.equals("Spades"))return 4;
	else return 0;
	}
	
	
	
	

} // end class Card
