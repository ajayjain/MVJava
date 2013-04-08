// Ajay Jain
// 1 April 2013
// GamePrep.java
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.IOException;

public class GamePrep {
	private ControlPanel controls;
	private ButtonPanel buttons;
	private JFrame frame;
	private GameRouter router;
	private JSlider cardSlider;
	
	public static void main (String[] args) {
		GamePrep gpa = new GamePrep();
		gpa.run();
	}
	
	public void run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 640);

		// Create the colors panel and buttons panel
		JPanel colorPicker = new JPanel();
		colorPicker.setLayout(new BorderLayout());

		JPanel colorPickerHeader = new JPanel();
		colorPickerHeader.setLayout(null);
		colorPickerHeader.add(new JLabel("Choose a colored card"));
		colorPickerHeader.add(new JButton("Select"));

		colorPicker.add(colorPickerHeader, BorderLayout.NORTH);

		buttons = new ButtonPanel();
		controls = new ControlPanel();

		frame.getContentPane().add(controls, BorderLayout.NORTH);
		router = new GameRouter();
		frame.getContentPane().add(router, BorderLayout.CENTER);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);

		// make the frame visible
		frame.setVisible(true);
	}

	class GameRouter extends JPanel {
		private LeadTablePanel leadTable;
		private ColorPanel colors;
		private Pacman pac;

		public GameRouter() {
			super();
			setLayout(new BorderLayout());

			// Leaderboard is the default page
			leadTable = new LeadTablePanel();
			showLeaderboard();
		}

		public void launchGame(String game) {
			// Clean up
			removeAll();
			updateUI();
			colors = null;
			pac = null;

			if (game.equals("Color Picker")) {
				JLabel top = new JLabel(" Choose a color:");
				top.setFont(new Font("Serif", Font.PLAIN, 20));
				add(top, BorderLayout.NORTH);

				colors = new ColorPanel();
				add(colors);

				cardSlider = new JSlider(1, 3, 0);
				cardSlider.setOrientation(JSlider.VERTICAL);
				cardSlider.addChangeListener(colors);
				add(cardSlider, BorderLayout.EAST);
			} else if (game.equals("Pacman (panel)")) {
				pac = new Pacman();
				pac.run();
				frame.addKeyListener(pac.panel);
				add(pac.panel);
			} else {
				showLeaderboard();
				launchProject(game);
			}
		}

		private void launchProject(String proj) {
			try {
				Runtime.getRuntime().exec(new String[] {"java", "-cp", "../"+proj, proj});
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		}	

		public void showLeaderboard() {
			removeAll();
			updateUI();
			add(leadTable);
		}
	}
	
	class ControlPanel extends JPanel implements ActionListener {
		private JButton launch, lead;
		private JTextField nameField;
		
		public ControlPanel() {
			// FlowLayout (default)
			launch = new JButton("NEW GAME");
			launch.addActionListener(this);
			add(launch);
			nameField = new JTextField("Username", 9);
			add(nameField);
			lead = new JButton("LEADERBOARD");
			lead.addActionListener(this);
			add(lead);
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("NEW GAME"))
				// Switch to first game - color picker
				router.launchGame("Color Picker");
			else if (e.getActionCommand().equals("LEADERBOARD"))
				router.showLeaderboard();
		}
	}

	class ButtonPanel extends JPanel implements ActionListener {
		private JButton[] gameButtons;
		private String[] gameNames =
			{"Color Picker", "Pacman (panel)", "Pacman", "Trail", "Draw", "Web", "Quote", "Calvin"};
		
		public ButtonPanel() {
			// Change FlowLayout (default) to GridLayout
			this.setLayout(new GridLayout(2, gameNames.length/2));
			// Initialize buttons
			gameButtons = new JButton[gameNames.length];
			for (int b = 0; b < gameNames.length; b++) {
				gameButtons[b] = new JButton (gameNames[b]);
				gameButtons[b].addActionListener(this);
				this.add(gameButtons[b]);
			}
		}
		
		public void actionPerformed (ActionEvent a) {
			router.launchGame(a.getActionCommand());
		}
	}

	///////////
	// GAMES //
	///////////
	
	// Panel containing table of scores
	class LeadTablePanel extends JPanel {
		private String[] columnNames = {"Username", "Date", "Score", "Color"};
		private Object[][] data = {
			{"Ajay", "4 April 2013", new Integer(1000), "Orange"},
			{"Daniel", "3 April 2013", new Integer(10), "Blue"},
			{"Alan", "4 April 2013", new Integer(10), "Red"}
		};
		
		public LeadTablePanel() {
			JTable table = new JTable(data, columnNames);
			add(table);
		}
	}

	class ColorPanel extends JPanel implements MouseListener, ChangeListener {
		// Declare CardLayout and JPanel objects
		private CardLayout cards;
		private JPanel color1, color2, color3;
		
		public ColorPanel() {
			// Initialize CardLayout and setLayout() to this panel
			cards = new CardLayout();
			this.setLayout(cards);
			
			// Create blue, green and red JPanels and set their backgrounds
			color1 = new JPanel();
			color1.setBackground(Color.blue);
			
			color2 = new JPanel();
			color2.setBackground(Color.green);

			color3 = new JPanel();
			color3.setBackground(Color.red);

			// Add the MouseListener to *each* JPanel and add each JPanel to ColorPanel (this)
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
			cardSlider.setValue((cardSlider.getValue() + 1) % 3);
		}
		public void stateChanged(ChangeEvent e) {
			cards.show(this, "Panel "+cardSlider.getValue());
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
	}
}