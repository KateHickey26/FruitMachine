// Kate Hickey
// 2032000H

import java.util.Random;

public class Model {

	// initiating arrays to hold the card values & the drawn cards, 
	// and an int variable to hold the balance
	private static String[] cards = new String[]{"Ace", "King", "Queen", "Jack", "Joker"};
	private static String[] drawnCards = new String[3];
	private static int balance = 100;
	
	// draw() method - contains the logic for randomly drawing cards
	// and then changes the balance value according to the cards drawn
	public static String draw() {
	    Random random = new Random();
	    int jokerCount = 0;
	    
	    // while the balance is more than 0 and less than 150 i.e. the player
	    // is still in a game, 3 random indices are chosen from the 'cards' array
	    // and stored in the 'drawnCards' array
	    while(balance>=0 && balance<150) {
	    	for (int i = 0; i < 3; i++) {
	    		drawnCards[i] = cards[random.nextInt(cards.length)];
	    		// for every instance of a Joker at any index of the new array,
	    		// the jokerCounter is increased
	    		if (drawnCards[i].equals("Joker")) {
	    			jokerCount++;
	    		}
	    	
	    	// if there is 1 joker, 25 points removed from balance
	    	}if (jokerCount==1) {
	    		balance -= 25;
	    		// check for the new balance making the game end:
	    		if(balance<0) {
	    			return jokerCount + " joker: you lose 25 points. Game over!";
	    		// if game didn't end:
	    		}else return jokerCount + " joker: you lose 25 points.";
	    	// if there are more than 1 jokers, 25 points is removed for each joker
	    	}else if (jokerCount >1) {
	    		balance -= (25*jokerCount); 
	    		// check for new balance making the game end:
	    		if(balance<0) {
	    			return jokerCount + " jokers: you lose " + (25*jokerCount) + " points. Game over!";
	    			// if game didn't end:
	    		}else return jokerCount + " jokers: you lose " + (25*jokerCount) + " points.";
	    	}
	    	
	    	// if all the cards are the same, 50 is added to balance
	    	if (drawnCards[0].equals(drawnCards[1]) && drawnCards[1].equals(drawnCards[2])) {
	    		balance += 50;
	    		// Check for new balance making the game end:
	    		if(balance >=150) {
	    			return "Three of a kind - you win 50 points! You win!";
	    		}else return "Three of a kind - you win 50 points!";
	    	
	    	// if 2 of the cards are the same, 20 is added to balance
	    	}else if (drawnCards[0].equals(drawnCards[1]) || drawnCards[0].equals(drawnCards[2]) || drawnCards[1].equals(drawnCards[2])) {
	    		balance += 20;
	    		// Check for new balance making the game end:
	    		if(balance >=150) {
	    			return "Two of a kind - you win 20 points! You Win!";
	    		}else return "Two of a kind - you win 20 points!";
	    		// if no cards the same, no change:
	    	}else return "No change";
	    }return null;
	}
	
	// getter for cards values in array
	public String[] getCards() {
	    return cards;
	}
	
	// getter for balance 
	public static int getBalance() {
	    return balance;
	}

	// getter for card at index x of drawnCards array
	public static String getDrawnCardAtX(int x) {
	    return drawnCards[x];
	}

	// setter for new value for balance
	public static void setBalance(int newBalance) {
	    balance = newBalance;
	}
}
