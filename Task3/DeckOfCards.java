/**
 * From Java How to Program Deitel and Deitel
 * @author Deitel and Deitel
 * @author Vindya Wijeratne
 * @version Last modified 11/05/2001
 * EDITED BY TANG YINGDUO JP093090
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeckOfCards extends JFrame {
	private Card deck[];
	private int currentCard;
	private JButton shuffleButton, gridButton[];	
	private JLabel status;
	private int totalScore = 0;
	private int numofc1 = 0;
	private int numofc2 = 0;
	private int numofc3 = 0;
		
	
	public DeckOfCards() {
		super("Card Grid game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six"};
		String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

		deck = new Card[24];
		currentCard = -1;

		
		//The following code generate the 24 cards
		//Attach them with faces and suits names
		//And transfer the names with values
		for (int i = 0; i < deck.length; i++) {
		deck[i] = new Card(faces[i % 6], suits[i / 6]);
		deck[i].faceValue = deck[i].faceToValue();
		deck[i].suitValue = deck[i].suitToValue();
		}
	

		//The creation of gridcards
		//But no card in grid card yet
		for (int i=0;i<gCard.length;i++){
		gCard[i] = new GridCards();
		gCard[i].gCardFace = 0;
		gCard[i].gCardSuit = 0;
		}
		
		
		this.getContentPane();
		this.setLayout(new BorderLayout());
					
		
		Container c = new JPanel();
		c.setLayout(new FlowLayout());
		
		shuffleButton = new JButton("Shuffle cards");
		shuffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status.setText("SHUFFLING ...");
				status.setText("DECK IS SHUFFLED");
				numofc1 = 0;
				numofc2 = 0;
				numofc3 = 0;
				totalScore = 0;
				shuffle();
				currentCard++;			
				for (int i=0; i < gridButton.length; i++){
				gridButton[i].setEnabled(true);//Enable all the 9 grid Buttons
				gridButton[i].setText(Integer.toString(i+1));//Display a serial number on each grid button
				}
				shuffleButton.setEnabled(false);//Disable the ¡®Shuffle Cards¡¯ button.	
				status.setText(deck[currentCard].toString()); //Change Status to Card Name
				//Show card number in status
				
					
			}
		});
		c.add(shuffleButton);
		
		
		status = new JLabel("SHUFFLE CARDS TO BEGIN");
		c.add(status);
		this.add(BorderLayout.NORTH,c);
			
			
		
		//A new container that contains the gridButtons
		Container d = new JPanel();
		d.setLayout(new GridLayout(3,3));		
		
		//The following is the added grid buttons
		gridButton = new JButton[9];
		
		
		for (int i=0; i < gridButton.length; i++){
		gridButton[i] = new JButton("");
		d.add(gridButton[i]);
		gridButton[i].setEnabled(false);
		final int k = i;
		gridButton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//Change gridButton's text to card name
				gridButton[k].setText(deck[currentCard].toString()); 
				
				//Give the card's face and suit value to grid card
				gCard[k].gCardFace = deck[currentCard].faceValue;
				gCard[k].gCardSuit = deck[currentCard].suitValue;
				
				//Disable grid Buttons
				gridButton[k].setEnabled(false);
							
				//Show the next card
				currentCard++;
				status.setText(deck[currentCard].toString());
								
												
				//Judging if it is already the last card
				if (currentCard == 9)
				{
				
				
		
				//Clicking on the last grid button 
				//Initiate the calculating of scores
				
				
				//A. Calculating the scores in rows
				for (int i=0;i<=6;i+=3){
			
				//1.Judging if there is a flush
				if (gCard[i].gCardSuit == gCard[i+1].gCardSuit &&
					gCard[i+1].gCardSuit == gCard[i+2].gCardSuit &&
					gCard[i].gCardSuit == gCard[i+2].gCardSuit)
				{if (gCard[i].gCardFace == 1 || gCard[i+1].gCardFace == 1 || gCard[i+2].gCardFace == 1 ) 
					{totalScore += 1000;numofc1+=1;}
				 else {totalScore +=500;numofc2+=1;}
				}
				
				//2.Judging if there is a Pair
				else if (gCard[i].gCardFace == gCard[i+1].gCardFace ||
					gCard[i+1].gCardFace == gCard[i+2].gCardFace ||
					gCard[i].gCardFace == gCard[i+2].gCardFace ){
					totalScore += 100; numofc3+=1;}
				}
				
				
				
				//B. Calculating the scores in columns
				for (int i=0;i<=2;i++){
				//1.Judging if there is a flush
				if (gCard[i].gCardSuit == gCard[i+3].gCardSuit && 
					gCard[i+3].gCardSuit == gCard[i+6].gCardSuit &&
					gCard[i].gCardSuit == gCard[i+6].gCardSuit)
				{if (gCard[i].gCardFace == 1 || gCard[i+3].gCardFace == 1 || gCard[i+6].gCardFace == 1 ) 
					{totalScore += 1000;numofc1+=1;}
				 else {totalScore +=500;numofc2+=1;}
				 }
				
				//2.Judging if there is a Pair
				else if (gCard[i].gCardFace == gCard[i+3].gCardFace ||
					gCard[i+3].gCardFace == gCard[i+6].gCardFace ||
					gCard[i].gCardFace == gCard[i+6].gCardFace ){
					totalScore += 100; numofc3+=1;}
				}
				
				status.setText("GAME OVER!");
				
				JOptionPane.showMessageDialog( null , 
				"TOTAL SCORE: "+totalScore+"\r\nNumber of Ace Flush: "+numofc1
				+"\r\nNumber of Flush: "+numofc2+"\r\nNumber of Pair: "+numofc3, "Game Over", 
				JOptionPane.INFORMATION_MESSAGE);
				
				status.setText("SHUFFLE CARDS TO BEGIN");				
				currentCard = -1;
				shuffleButton.setEnabled(true);
				//Enable shuffleButton
				
				}
				
				}
				
			});
		}
		
		this.add(BorderLayout.CENTER,d);		
		setSize(500, 300); // set the window size
		setVisible(true); // show the window
		
	}
		
	
	public class GridCards{
	public int gCardFace;
	public int gCardSuit;}
	GridCards[] gCard = new GridCards[9];	
	
	
	public void shuffle() {
		currentCard = -1;
		for (int i = 0; i < deck.length; i++) {
			int j = (int) (Math.random() * 24);
			Card temp = deck[i]; // swap
			deck[i] = deck[j]; // the
			deck[j] = temp; // cards
		}
	}

	public static void main(String args[]) {
		DeckOfCards app = new DeckOfCards();
	}
}