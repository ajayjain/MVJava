// Ajay Jain
// February 23, 2013
// SlimeRun.java
// Final game project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;

public class SlimeRun {
	private JFrame frame;
	private StartScreen startPanel;
	private GamePanel gamePanel;
	
	public static void main(String[] args) {
		(new SlimeRun()).init();
	}
	
	// Set up frame, show start screen
	public void init() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(32*15, 32*6);
		frame.setLocation(200, 100);
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
		frame.getContentPane().add(gamePanel);
	}
	
	class GamePanel extends JPanel {	
		private MainPanel main;
		private JPanel top;
		private JButton quit, help;
		private JFrame myframe;
		
		public GamePanel() {
			setLayout(new BorderLayout());
			
			createTopBar();
			
			main = new MainPanel();
			add(main, BorderLayout.CENTER);
		}
		
		public void createTopBar() {
			// Button to go to main screen
			quit = new JButton("Quit");
			quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					startPanel.setVisible(true);
					main.stopGame();
					gamePanel = null;	// Destroy game
				}
			});
			help = new JButton("Help");
			
			// Add components to top panel
			top = new JPanel();
			top.setBackground(Color.green);
			top.setPreferredSize(new Dimension(frame.getWidth(), 33));	// Block size 32 px
			top.setLayout(new BorderLayout());
			top.add(quit, BorderLayout.WEST);
			top.add(help, BorderLayout.EAST);
			// Add top panel to game panel
			add(top, BorderLayout.NORTH);
		}
		
		private void askQuestion() {
		
		}
		
		//class TopPanel extends JPanel implements MouseListener {}
		
		class MainPanel extends JPanel implements KeyListener {
			private byte[] map = new byte[15];
			
			private Slime player;	// The player
			private Image blockImage; // Image of a block
			private Timer timer;	// 2 milisecond game loop
			private int w = getWidth(), h = getHeight();
			
			public MainPanel() {
				super();
				
				setBackground(Color.pink);
				
				player = new Slime();
				loadBlockImage();
				
				// Generate a map, skipping the first 3 columns
				generateMap(3);
				
				timer = new Timer(4, new GameLoop());
				timer.start();
				
				// Start listening for key presses
				addKeyListener(this);
			}
			
			// Load image of the basic block
			private void loadBlockImage() {
				try {
					blockImage = ImageIO.read(new File("images/blocks/basic.png"));
					System.out.println("Loaded ./images/blocks/basic.png");
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}	
			}
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draw slime character
				player.drawSlime(g, this);
				
				// Draw map
				drawMap(g);
			}
			
			// Draws blocks
			private void drawMap(Graphics g) {
				// Draw floor
				for (int col = 0; col < map.length; col++) {
					g.setColor(Color.black);
					g.drawImage(blockImage, col*32, 3*32, 32, 32, this);
					//g.drawRect(col*32, 3*32, 32, 32);
					
					switch (map[col]) {
						case GameObject.BUMP:
							g.drawImage(blockImage, col*32, 2*32, 32, 32, this);	// Draw bump
							// Draw question mark
							g.setColor(Color.red);
							g.setFont(new Font("Sans-Serif", Font.BOLD, 20));
							g.drawString("?", col*32+11, 2*32+25);
							break;
						case GameObject.OVERHANG:
							g.drawImage(blockImage, col*32, 0, 32, 73, this);	// Draw overhang
							// Draw question mark
							g.setColor(Color.red);
							g.setFont(new Font("Sans-Serif", Font.BOLD, 20));
							g.drawString("?", col*32+11, 1*32+35);
					}
				}
			}
			
			// Generate map for one screen.
			// numberToSkip - Columns to skip
			private void generateMap(int numberToSkip) {
				// Clear map
				for (int col = 0; col < map.length; col++)
					map[col] = GameObject.AIR;
				
				for (int col = 0; col < map.length; col++) {
					// Skip the first startCol columns
					if (numberToSkip > 0) {
						numberToSkip--;
						continue;
					}
					
					double rand = Math.random();
					if (rand > .8) {
						map[col] = GameObject.BUMP;
						// Skip a column so the user can actually jump over a bump
						numberToSkip = 2;
					} else if (rand > .6) {
						map[col] = GameObject.OVERHANG;
						numberToSkip = 1;
					}
				}
			}
			
			public void stopGame() {
				timer.stop();
				player = null;
			}
			
			// Update slime properties on key press
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
					case 'w':
						player.jump();
						break;
					case 's':
						player.duck();
				}
			}
			
			// Stop slide
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == 's')
					player.stand();
			}
			
			public void keyTyped(KeyEvent e) {};
		
			class GameLoop implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					main.repaint();
					main.grabFocus();
					
					detectCollision();
					
					// Update map for next painting
					player.move();
					// If the player passed the edge of the screen
					if (player.x >= 32*15) {
						generateMap(3);	// Regenerate the map
						player.x = 0; // Move to start
					}
				}
				
				// Collision detection for player
				private void detectCollision() {
					int playerColumn = (int) (player.x/32);
					if (map[playerColumn] == GameObject.BUMP && player.y >= 32*2) {
						askQuestion();
						System.out.println("Hit BUMP");
					}
					if (map[playerColumn] == GameObject.OVERHANG && player.y <= 73) {
						askQuestion();
						System.out.println("Hit OVERHANG");
					}
				}
			}
		}
	}
}
