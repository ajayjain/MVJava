// Ajay Jain
// February 23, 2013
// SlimeRun.java
// Final game project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlimeRun {
	private JFrame frame;
	private StartScreen startPanel;
	private GamePanel gamePanel;
	
	//public SlimeRun() {}
	public static void main(String[] args) {
		(new SlimeRun()).init();
	}
	
	// Set up frame, show start screen
	public void init() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setResizable(false);
		
		startPanel = new StartScreen();
		startPanel.addStartListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				run();
			}
		});
		frame.getContentPane().add(startPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	// Launch actual game
	private void run() {
		gamePanel = new GamePanel();
		gamePanel.createTopBar();
		frame.getContentPane().add(gamePanel);
	}
	
	class GamePanel extends JPanel {	
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
					gamePanel = null;	// Destroy game
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
}
