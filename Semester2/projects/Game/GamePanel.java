// Ajay Jain
// February 23, 2013
// GamePanel.java
// Panel containing level

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {	
	public GamePanel() {
		setLayout(new BorderLayout());
	}
	
	public void createTopBar() {
		// Button to go to main screen
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				startPanel.setVisible(true);
				gamePanel = null;
			}
		});
		
		// Add components to top panel
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(quit, BorderLayout.WEST);
		// Add top panel to game panel
		add(top, BorderLayout.NORTH);
	}
}
