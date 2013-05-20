// Ajay Jain
// February 23, 2013
// StartScreen.java
// Main menu of SlimeRun

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartScreen extends JPanel {
	private JPanel north;	// Top panel with game title
	
	private JPanel center;	// Center panel with character and subject choosers
	private JPanel subjectChooser;	// Panel containing subject options
	private String[] subjectNames = {"Electricity and Magnetism", "Simple Machines", "Anatomy", "SAT Vocabulary", "Spanish"};	// Available subjects
	public JRadioButton[] subjects;	// JRadioButtons within subjectChooser
	
	private JButton start;	// Start button to launch game
	
	public StartScreen() {
		super();
		setLayout(new BorderLayout());
		
		north = new JPanel();
		north.setBackground(Color.green);
		north.add(new JLabel("SLIME RUN"));
		add(north, BorderLayout.NORTH);
		
		center = new JPanel();
		center.setBackground(new Color(105, 204, 255, 150));
		center.setLayout(new GridLayout(1, 2));
		// Left side
		center.add(new JLabel("Flash cards go here"));
		// Right side
		createSubjectChooser();
		center.add(subjectChooser);
		add(center, BorderLayout.CENTER);
		
		start = new JButton("START");
		subjectChooser.add(start, BorderLayout.SOUTH);
	}
	
	private void createSubjectChooser() {
		// Create panel
		subjectChooser = new JPanel();
		subjectChooser.setLayout(new BorderLayout());
		subjectChooser.setBackground(new Color(105, 204, 255, 150));
		//subjectChooser.setLayout(new GridLayout(2, 1));
		// Add label
		//subjectChooser.add(new JLabel("Select subject(s):"));
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(null);
		radioPanel.setBackground(Color.orange);
		ButtonGroup subjectGroup = new ButtonGroup();
		// Initialize JRadioButtons
		subjects = new JRadioButton[subjectNames.length];
		for (byte i = 0; i < subjectNames.length; i++) {
			subjects[i] = new JRadioButton(subjectNames[i]);
			subjects[i].setBounds(10, 20*i+50, 32*14+10, 20);
			subjectGroup.add(subjects[i]);	// add to group
			radioPanel.add(subjects[i]);	// add to panel
		}
		subjects[0].setSelected(true);
		subjectChooser.add(radioPanel);
	}
	
	public void addStartListener(ActionListener listener) {
		start.addActionListener(listener);
		/*new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.actionPerformed(e);
			}
		});*/
	}
}

class FlashCardPanel extends JPanel {
	public FlashCardPanel() {
		
	}
}
