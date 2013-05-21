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
	
	private MissedIO missedIO = new MissedIO();
	private String[][] missed = missedIO.read();
	
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
		center.add(new FlashCardPanel());
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
		subjectChooser.add(new JLabel("Select a subject:"), BorderLayout.NORTH);
		
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

	public void loadMissed() {
		missed = missedIO.read();
	}
	

	class FlashCardPanel extends JPanel {
		private JSplitPane question;
		private JTextArea qArea, aArea;
		private int currq = 0;	// Current question
		private JPanel south;
		private JButton next, prev;
		
		public FlashCardPanel() {
			super();
			setLayout(new BorderLayout());
			setBackground(new Color(105, 204, 255, 150));
			add(new JLabel("Previously missed:"), BorderLayout.NORTH);
			
			createSplitPane();
			add(question);
			
			south = new JPanel();
			south.setLayout(new GridLayout(1,2));
			
			// Create buttons for going forward and back
			prev = new JButton("Previous");
			prev.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currq--;
					if (currq < 0) currq = missed.length-1;
					qArea.setText(missed[currq][0]);
					aArea.setText(missed[currq][1]);
				}
			});
			south.add(prev);
			
			next = new JButton("Next");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currq = (currq+1) % missed.length;
					qArea.setText(missed[currq][0]);
					aArea.setText(missed[currq][1]);
				}
			});
			south.add(next);
			
			add(south, BorderLayout.SOUTH);
		}
		
		private void createSplitPane() {
			// Question boxe
			qArea = new JTextArea(missed[currq][0]);
			qArea.setEditable(false);
			qArea.setLineWrap(true);
			qArea.setForeground(Color.blue);
			
			// Answer box
			aArea = new JTextArea(missed[currq][1]);
			aArea.setEditable(false);
			aArea.setLineWrap(true);
			aArea.setForeground(Color.blue);
			question = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, qArea, aArea);
		}
		
		/*class FlashCards extends JPanel {
			public FlashCards() {
				super();
			}
		}*/
	}
}
