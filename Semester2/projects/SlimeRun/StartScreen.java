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
	private String[] subjectNames = {"Physics", "Biology", "English"};	// Available subjects
	private JRadioButton[] subjects;	// JRadioButtons within subjectChooser
	
	private JButton start;	// Start button to launch game
	
	public StartScreen() {
		setLayout(new BorderLayout());
		
		north = new JPanel();
<<<<<<< HEAD
		north.setBackground(Color.green);
=======
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
		north.add(new JLabel("SLIME RUN"));
		add(north, BorderLayout.NORTH);
		
		center = new JPanel();
<<<<<<< HEAD
		center.setBackground(new Color(105, 204, 255, 150));
=======
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
		center.setLayout(new GridLayout(1, 2));
		// Left side
		center.add(new JLabel("Character chooser goes here"));
		// Right side
		createSubjectChooser();
		center.add(subjectChooser);
		add(center, BorderLayout.CENTER);
		
		start = new JButton("START");
		add(start, BorderLayout.SOUTH);
	}
	
	private void createSubjectChooser() {
		// Create panel
		subjectChooser = new JPanel();
<<<<<<< HEAD
		subjectChooser.setBackground(new Color(105, 204, 255, 150));
=======
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
		//subjectChooser.setLayout(new GridLayout(2, 1));
		// Add label
		//subjectChooser.add(new JLabel("Select subject(s):"));
		
		JPanel radioPanel = new JPanel();
<<<<<<< HEAD
		radioPanel.setBackground(new Color(105, 204, 255, 150));
=======
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
		ButtonGroup subjectGroup = new ButtonGroup();
		// Initialize JRadioButtons
		subjects = new JRadioButton[subjectNames.length];
		for (byte i = 0; i < subjectNames.length; i++) {
			subjects[i] = new JRadioButton(subjectNames[i]);
			subjectGroup.add(subjects[i]);	// add to group
			radioPanel.add(subjects[i]);	// add to panel
		}
		subjects[0].setSelected(true);
		subjectChooser.add(radioPanel);
	}
	
	public void addStartListener(ActionListener listener) {
		start.addActionListener(listener);
	}
}
