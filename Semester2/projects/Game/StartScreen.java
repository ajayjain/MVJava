// Ajay Jain
// February 23, 2013
// StartScreen.java
// Main menu of SlimeRun

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class StartScreen extends JPanel {
	private JPanel north;	// Top panel with game title
	
	private JPanel center;	// Center panel with character and subject choosers
	private JPanel subjectChooser;	// Panel containing subject options
	private String[] subjectNames = {"Electricity and Magnetism", "Simple Machines", "Anatomy", "SAT Vocabulary", "Spanish"};	// Available subjects
	public JRadioButton[] subjects;	// JRadioButtons within subjectChooser
	private JSlider difficulty;
	
	private MissedIO missedIO = new MissedIO();
	private String[][] missed = missedIO.read();
	
	private JButton start;	// Start button to launch game
	
	private Color blueColor = new Color(105, 204, 255);
    private Font boldFont = new Font("Arial", Font.BOLD, 14);
    private Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private Border blueBorder = BorderFactory.createLineBorder(blueColor, 3);
    private Border headerBorder = BorderFactory.createCompoundBorder(blueBorder, paddingBorder);
	
	public StartScreen() {
		super();
		setLayout(new BorderLayout());
		
		/*north = new JPanel();
		north.setBackground(Color.green);
		north.add(new JLabel("SLIME RUN"));
		add(north, BorderLayout.NORTH);*/
		
		center = new JPanel();
		center.setBackground(blueColor);
		center.setLayout(new GridLayout(1, 2));
		// Left side
		center.add(new FlashCardPanel());
		// Right side
		createSubjectChooser();
		center.add(subjectChooser);
		add(center, BorderLayout.CENTER);
		
		// Panel for difficulty slider and start button
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2, 1));
		
		// Panel for difficulty slider
		JPanel diffPanel = new JPanel();
		diffPanel.setBackground(blueColor);
		diffPanel.add(new JLabel("Difficulty:"));
		// Create slider
		difficulty = new JSlider(10, 40, 20);
		difficulty.setSnapToTicks(false);
		// difficulty.setMinorTickSpacing(1);
		// System.out.println(difficulty.getSnapToTicks());
		difficulty.setBackground(blueColor);
		difficulty.setToolTipText("Difficulty");
		diffPanel.add(difficulty);
		south.add(diffPanel);
		
		start = new JButton("START");
		south.add(start);
		
		subjectChooser.add(south, BorderLayout.SOUTH);
	}
	
	private void createSubjectChooser() {
		// Create panel
		subjectChooser = new JPanel();
		subjectChooser.setLayout(new BorderLayout());
		//subjectChooser.setBackground(new Color(105, 204, 255, 150));
        
		// Add label
        JLabel rightHeader = new JLabel("Select a subject:", JLabel.CENTER);
        rightHeader.setFont(boldFont);
        rightHeader.setBorder(headerBorder);
		subjectChooser.add(rightHeader, BorderLayout.NORTH);
        
		JPanel radioPanel = new JPanel();
        
        /*JLabel directions = new JLabel(
            "<html><p><strong>Instructions:</strong>"+
            "<table><tr><td>jump</td><td>duck</td><td>pause/resume</td></tr>"+
            "<tr><td>[W] or [UP]</td><td>[S] or [DOWN]</td><td>[ESC] or [P]</td></tr>"+
            "</table></p></html>");*/
        JLabel directions = new JLabel("<html><p><strong>Instructions:</strong> W/UP - jump, S/DOWN - crouch, ESC/P - pause</p></html>", JLabel.CENTER);
        directions.setBounds(0, 0, (64*15+10)/2-20, 60);
        radioPanel.add(directions);
		
        radioPanel.setLayout(null);
		radioPanel.setBackground(Color.orange);
		ButtonGroup subjectGroup = new ButtonGroup();
		// Initialize JRadioButtons
		subjects = new JRadioButton[subjectNames.length];
		for (byte i = 0; i < subjectNames.length; i++) {
			subjects[i] = new JRadioButton(subjectNames[i]);
			subjects[i].setBounds(10, 20*i+50, 32*14+10, 20);
			subjects[i].setBackground(Color.orange);
			subjectGroup.add(subjects[i]);	// add to group
			radioPanel.add(subjects[i]);	// add to panel
		}
		subjects[0].setSelected(true);
		subjectChooser.add(radioPanel);
	}
	
	public void addStartListener(ActionListener listener) {
		start.addActionListener(listener);
	}

	public void loadMissed() {
		missed = missedIO.read();
	}
	
	public double getDifficulty() {
		return difficulty.getValue()/10.0;
	}

	class FlashCardPanel extends JPanel {
		private JSplitPane question;
		private JTextArea qArea, aArea;
		private int currq = 0;	// Current question
		private JPanel south;
		private JButton next, prev, rand;
		
		public FlashCardPanel() {
			super();
			setLayout(new BorderLayout());
            JLabel leftHeader = new JLabel("Previously missed:", JLabel.CENTER);
            leftHeader.setFont(boldFont);
            leftHeader.setBorder(headerBorder);
			add(leftHeader, BorderLayout.NORTH);
			
			createSplitPane();
			add(question);
			
			south = new JPanel();
			south.setLayout(new GridLayout(1,3));
			
			// Create buttons for going forward and back
			prev = new JButton("Previous");
			prev.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currq--;
					if (currq < 0) currq = missed.length-1;
					updateMissedText();
				}
			});
			south.add(prev);
			
			rand = new JButton("Random");
			rand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// currq--;
					// if (currq < 0) currq = missed.length-1;
					currq = new java.util.Random().nextInt(missed.length);
					updateMissedText();
				}
			});
			south.add(rand);
			
			next = new JButton("Next");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currq = (currq+1) % missed.length;
					updateMissedText();
				}
			});
			south.add(next);
			
			add(south, BorderLayout.SOUTH);
		}
		
		// Update the text of the text areas
		private void updateMissedText() {
			qArea.setText(missed[currq][0]);
			//qArea.setText("<html><h2>Question:</h2>"+missed[currq][0]+"</h2></html>");
			aArea.setText(missed[currq][1]);
		}
		
		private void createSplitPane() {
			// Question boxes
			qArea = new JTextArea(missed[currq][0]);
			qArea.setEditable(false);
			qArea.setLineWrap(true);
			qArea.setForeground(Color.blue);
			qArea.setFont(boldFont);
			
			// Answer box
			aArea = new JTextArea(missed[currq][1]);
			aArea.setEditable(false);
			aArea.setLineWrap(true);
			aArea.setForeground(Color.blue);
			aArea.setFont(boldFont);
			
			question = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, qArea, aArea);
			//question.setBackground(new Color(105, 204, 255, 150));
		}
		
		/*class FlashCards extends JPanel {
			public FlashCards() {
				super();
			}
		}*/
	}
}
