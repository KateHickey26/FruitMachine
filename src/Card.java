// Kate Hickey
// 2032000H

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Card extends JPanel {

	// constructor for card object
    public Card() {
        setBackground(Color.lightGray); 
        setBorder(BorderFactory.createRaisedBevelBorder()); 
        // GridBagLayout will centre a JLabel:
        setLayout(new GridBagLayout()); 
        
    }
}