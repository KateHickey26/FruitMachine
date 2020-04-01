// Kate Hickey
// 2032000H

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ViewController extends JFrame implements ActionListener{
	// initialising JLabels and JButtons, so they can be used in the constructor 
	// and also in the actionPerformed() method
	JLabel cards = new JLabel("Welcome");
	JLabel balanceLabel = new JLabel("Balance is " + Model.getBalance());
	JLabel card1Label = new JLabel("King", SwingConstants.CENTER);
	JLabel card2Label = new JLabel("Queen", SwingConstants.CENTER);
	JLabel card3Label = new JLabel("Jack", SwingConstants.CENTER);
	JButton spinButton = new JButton("Spin");
	JButton newGameButton = new JButton("New Game");
	
	// constructor
	public ViewController(Model FMModel) {	
		// general JFrame 
		this.setTitle("Fruit Machine");
		this.setSize(800,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
	
		// creating the panels
		JPanel northPanel = new JPanel();	
		JPanel eastPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel centerPanel = new JPanel (new GridLayout(2,2));
		
		// setting the 4 outer panels to white gives a white border to the game
		northPanel.setBackground(Color.lightGray);
	    eastPanel.setBackground(Color.lightGray);
	    westPanel.setBackground(Color.lightGray);
	    southPanel.setBackground(Color.lightGray);
	    // ill be putting the rest of my JPanels in the centerPanel
	    // which will expand to fit everything, leaving a light gray border
	
	
	    // creating the top left panel
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
		labelsPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		// adding the two labels to the panel
		labelsPanel.add(balanceLabel);
		labelsPanel.add(cards);
		// adding the panel to the centerPanel 
		centerPanel.add(labelsPanel);
		
		// creating the upper right panel, blank
		JPanel blankPanel = new JPanel();
		// added to centerPanel next (must be added in order)
		centerPanel.add(blankPanel);
		
		// creating the lower left panel, holding the cards
		JPanel cardPanel = new JPanel(new FlowLayout());
		cardPanel.setLayout(new GridLayout(0, 3, 30, 0));
		cardPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		// creating 3 card panels and adding labels to them
		JPanel card1 = new Card();
		card1.setSize(50,50);
		card1.add(card1Label);
	    JPanel card2 = new Card();
	    card2.add(card2Label);
	    JPanel card3 = new Card();
	    card3.add(card3Label);
	    // adding the 3 cards to the cardPanel
	    cardPanel.add(card1);
	    cardPanel.add(card2);
	    cardPanel.add(card3);
	    // adding the cardPanel to the centerPanel
	    centerPanel.add(cardPanel);
	    
	    // creating the lower right panel, holding the buttons
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
		// setting the spinButton size and adding the action listener
		spinButton.setPreferredSize(new Dimension(100,40));
		spinButton.addActionListener(this);
		// setting the newGameButton size, disabling it (for now) and adding the action listener
		newGameButton.setPreferredSize(new Dimension(100,40));
		newGameButton.setEnabled(false);
		newGameButton.addActionListener(this);
		// adding the buttons to the buttonPanel
		buttonPanel.add(spinButton);
		buttonPanel.add(newGameButton);
		// adding the buttonPanel to the centerPanel
		centerPanel.add(buttonPanel);
		
		// adding the panels to the main Border Layout
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	
	/* action performed method. 
	 * I used one action listener / action performed method for both
	 * buttons. An 'if' statement determines what happens 
	 * depending on which button was pressed.  */
	public void actionPerformed(ActionEvent e) {
		
		// if the spinButton was pressed, the draw() method is implemented
		// the new cards/ balance/ labels are shown.
		if (e.getSource() == spinButton) {
			newGameButton.setEnabled(false);
			cards.setText(Model.draw());
			balanceLabel.setText("Balance is " + Model.getBalance());
			card1Label.setText(Model.getDrawnCardAtX(0));
			card2Label.setText(Model.getDrawnCardAtX(1));
			card3Label.setText(Model.getDrawnCardAtX(2));
			// checking the new balance after draw() method, to check which button should be left active
			if ((Model.getBalance()>=150) || (Model.getBalance()<0)){
				spinButton.setEnabled(false);
				newGameButton.setEnabled(true);
			}
		
		// if the newGameButton was pressed the game values are reset
		}else if(e.getSource() == newGameButton){
			Model.setBalance(100);
			newGameButton.setEnabled(false);
			spinButton.setEnabled(true);
			balanceLabel.setText("Balance is: " + Model.getBalance());	
			card1Label.setText("King");
			card2Label.setText("Queen");
			card3Label.setText("Jack");
			cards.setText("Welcome");
		// now that the values have been reset & the spinButton	enabled, 
		//the newGameButton will not be enabled until the game is over again.
		}	
	}
}
