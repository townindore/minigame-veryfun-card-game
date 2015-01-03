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
	
	public DeckOfCards() {
		super("Card Grid game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six"};
		String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

		deck = new Card[24];
		currentCard = -1;

		for (int i = 0; i < deck.length; i++) deck[i] = new Card(faces[i % 6], suits[i / 6]);
		
		this.getContentPane();
		this.setLayout(new BorderLayout());
					
		
		Container c = new JPanel();
		c.setLayout(new FlowLayout());
		
		shuffleButton = new JButton("Shuffle cards");
		shuffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status.setText("SHUFFLING ...");
				shuffle();
				status.setText("DECK IS SHUFFLED");
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
		}
		
		this.add(BorderLayout.CENTER,d);
		
		setSize(400, 500); // set the window size
		setVisible(true); // show the window
	}

	
	
	
	
	
	
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