// Ajay Jain
// January 22, 2013
// SimpleJFrame.java
// This program

// Topics: JFrame
//	1. how to create a JFrame object (window_
//	2. settings of JFrame
//	3. JFrame components - JLabel, JButton

import java.awt.*;
import javax.swing.*;

public class SimpleJFrame {
	/* public SimpleJFrame(String title) {
		setTitle(title);
	} */
	
	public static void main(String[] args) {
		// Create JFrame object
		JFrame frame = new JFrame("1337 JFrame!");
		
		// Set the parameters on the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create components
		JLabel emptyLabel = new JLabel("Empty");
		JButton bigButton = new JButton("BIG");
		JButton littleButton = new JButton("little");
		
		// Add components them into the Content Pane of the JFrame
		frame.getContentPane().add(emptyLabel, BorderLayout.NORTH);
		frame.getContentPane().add(bigButton, BorderLayout.WEST);
		frame.getContentPane().add(littleButton, BorderLayout.EAST);
		
		// Size the frame and put in specific location
		frame.setSize(300, 100);	// Explicitly sets size of JFrame
		frame.setLocation(200, 300);
		
		frame.setVisible(true);		// false -> hidden
	}
	
	/*public void paint() {
		
	}*/
}
