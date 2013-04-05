// Mr Greenstein
// March 29, 2013
// MyFrame.java
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout.

// Topics:
//	1. JFrame default is BorderLayout; JPanel default is FlowLayout
//	2. Change FlowLayout to GridLayout
//	3. How to setup CardLayout

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame {
	private MyColorPanel colors;
	private MyButtonPanel buttons;
	private JFrame frame;
	
	public static void main (String[] args) {
		MyFrame gpa = new MyFrame();
		gpa.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// Create the colors panel and buttons panel
		colors = new MyColorPanel();
		buttons = new MyButtonPanel();
		buttons.setBackground(Color.gray);
		
		// add the JPanels to the frame
		frame.getContentPane().add(colors, BorderLayout.CENTER);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class MyColorPanel extends JPanel implements MouseListener {
		//////////////////////////////////////////////////////////
		// Declare CardLayout and JPanel objects
		private CardLayout cards;
		private JPanel color1, color2, color3;
		
		public MyColorPanel() {			// constructor
			////////////////////////////////////////////////////////
			// Initialize CardLayout and setLayout() to this panel
			cards = new CardLayout();
			this.setLayout(cards);
			
			////////////////////////////////////////////////////////
			// Create blue, green and red JPanels and set their backgrounds
			color1 = new JPanel();
			color1.setBackground(Color.blue);
			
			color2 = new JPanel();
			color2.setBackground(Color.green);

			color3 = new JPanel();
			color3.setBackground(Color.red);

			////////////////////////////////////////////////////////
			// Add the MouseListener to *each* JPanel and add
			// each JPanel to MyColorPanel (this)
			color1.addMouseListener(this);
			color2.addMouseListener(this);
			color3.addMouseListener(this);
			
			add(color1, "Panel 1");
			add(color2, "Panel 2");
			add(color3, "Panel 3");
		}
		public void mousePressed(MouseEvent evt) {
			////////////////////////////////////////////////////////
			// Select the next panel on the stack of panels
			cards.next(this);
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
	}
	
	class MyButtonPanel extends JPanel implements ActionListener {
		private JButton lang1, lang2, lang3;
		private JTextField langField;
		private String[] languages = { "English", "French", "German" };
		
		public MyButtonPanel() {
			////////////////////////////////////////////////////////
			// Change FlowLayout (default) to GridLayout
			// with 1 row and 4 columns.
			this.setLayout(new GridLayout(1,4));
					
			lang1 = new JButton (languages[0]);
			lang1.addActionListener(this); 		
			this.add(lang1);
			lang2 = new JButton (languages[1]);
			lang2.addActionListener(this); 		
			this.add(lang2);
			lang3 = new JButton (languages[2]);
			lang3.addActionListener(this); 		
			this.add(lang3);
			langField = new JTextField(languages[0], 9);
			this.add(langField);
		}
		
		public void actionPerformed (ActionEvent a) {
			String command = a.getActionCommand();
			for (int i=0; i < 3; i++)
				if (command.equals(languages[i])) langField.setText(languages[i]);
		}
	}
}
