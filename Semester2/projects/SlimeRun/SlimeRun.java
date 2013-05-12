// Ajay Jain
// February 23, 2013
// SlimeRun.java
// Final game project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;

import java.util.Random;

public class SlimeRun {
	private JFrame frame;
	private StartScreen startPanel;
	private GamePanel gamePanel;
	private QuestionLoader questions;
	private QuestionFrame qframe;
	
	public static void main(String[] args) {
		(new SlimeRun()).init();
	}
	
	// Set up frame, show start screen
	public void init() {
		// Begin loading questions
		questions = new QuestionLoader();
		questions.start();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(32*15+10, 32*6);
		frame.setLocation(200, 100);
		frame.setResizable(false);
		
		// Create start screen
		startPanel = new StartScreen();
		// Attach a listener that fires on start button press
		startPanel.addStartListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				run();
			}
		});
		// Add start screen
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
		private JMenuBar top;
		private JButton quit, resume;
		private JLabel directions;
		
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
					// Hide panels
					setVisible(false);
					startPanel.setVisible(true);
					
					// Stop and destroy the game
					main.timer.stop();
					main.player = null;
					main = null;
					gamePanel = null;
				}
			});
			//resume
			
			// Game instructions
			directions = new JLabel(" [W]/[UP] to jump, [S]/[DOWN] to crouch, [ESC] to pause");
			
			// Add components to top panel
			top = new JMenuBar();
			top.setBackground(new Color(105, 204, 255, 150));
			top.setPreferredSize(new Dimension(frame.getWidth(), 33));	// Block size 32 px
			top.add(quit);
			top.add(directions);
			add(top, BorderLayout.NORTH);
		}
		
		//class TopPanel extends JPanel implements MouseListener {}
		
		class MainPanel extends JPanel		 {
			private byte[] map = new byte[15];
			
			Slime player;	// The player
			private Image blockImage; // Image of a block
			Timer timer;	// 2 milisecond game loop
			private int w = getWidth(), h = getHeight();
			private boolean paused = false;
			
			public MainPanel() {
				super();
				
				setBackground(Color.pink);
				
				player = new Slime();
				loadBlockImage();
				
				// Generate a map, skipping the first 3 columns
				generateMap(3);
				
				timer = new Timer(6, new GameLoop());
				timer.start();
				// Start listening for key presses
				//addKeyListener(this);
				bindKeyStrokes();

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
			
			private void askQuestion() {
				pauseGame();
				
				if (qframe == null)
					// Create JFrame for question and answers
					qframe = new QuestionFrame();
				
				// Create listeners for when question is answered
				IncorrectListener il = new IncorrectListener();
				CorrectListener cl = new CorrectListener();
				
				if (startPanel.subjects[0].isSelected())
					askPhysicsQuestion(il, cl);
			}
			
			private void askPhysicsQuestion(ActionListener il, ActionListener cl) {
				Random rand = new Random();
				int randIndex = rand.nextInt(questions.physics.length);
				String[] question = questions.physics[randIndex];
				
				// Init JButton array for each choice
				JButton[] choices = new JButton[4];
				// Randomly place the button for the correct choice in the choices array
				int correctIndex = rand.nextInt(4);
				choices[correctIndex] = new JButton(question[1]);
				choices[correctIndex].addActionListener(cl);	// Add listener that is called on selection of the correct choice
				for (int i = 0; i < 4; i++) {
					if (i == correctIndex) continue;	// Skip the correct choice (already placed)
					randIndex = rand.nextInt(questions.physics.length);	// Choose a random index
					String choice = questions.physics[randIndex][0];	// Text of answer choice from the data set
					choices[i] = new JButton(choice);
					choices[i].addActionListener(il);	// Incorrect answer
				}
				
				qframe.askQuestion(question, choices);
				qframe.setVisible(true);
			}
			
			class IncorrectListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					System.out.println("INCORRECT");
				}
			}
			
			class CorrectListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					System.out.println("CORRECT");
					// Hide question dialouge
					qframe.setVisible(false);
					// Free the player from the colliding block
					map[player.getColumn()] = GameObject.AIR;
					// Stop movement (player had hit an object)
					player.vel_x = 0;
					player.vel_y = 0;
					// Repaint to hide destroyed pblock
					repaint();
				}
			}
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				// Draw slime character
				player.drawSlime(g, this);
				// Draw map
				drawMap(g);
				
				if (paused) {
					g.setFont(new Font("Sans-Serif", Font.BOLD, 40));
					g.setColor(Color.blue);
					g.drawString("PAUSED", 165, 60);
					g.setFont(new Font("Sans-Serif", Font.BOLD, 16));
					g.drawString("Press [P] or [ESC]", 175, 80);
				}
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
						numberToSkip = 2;
					}
				}
			}
			
			// Pause the game
			private void pauseGame() {
				paused = true;
				repaint();
				timer.stop();
			}
			
			private void resumeGame() {
				timer.start();
				paused = false;
			}

			private void bindKeyStrokes() {
				InputMap in = getInputMap();
				ActionMap ac = getActionMap();
				
				// Jump
				in.put(KeyStroke.getKeyStroke('w'), "jump");
				in.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "jump");
				ac.put("jump", new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						player.jump();
					}
				});

				// Duck
				in.put(KeyStroke.getKeyStroke('s'), "duck");
				in.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "duck");
				ac.put("duck", new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						player.duck();
					}
				});

				// Stand
				in.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "stand");
				in.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "stand");
				ac.put("stand", new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						player.stand();
					}
				});

				// Pause
				in.put(KeyStroke.getKeyStroke('p'), "pause");
				in.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pause");
				ac.put("pause", new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						if (paused)
							resumeGame();
						else
							pauseGame();
					}
				});
			}

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
					int playerColumn = player.getColumn();
					if (map[playerColumn] == GameObject.BUMP && player.y >= 32*2) {
						askQuestion();
						System.out.println("Overlapping BUMP");
					}
					if (map[playerColumn] == GameObject.OVERHANG && player.y <= 73) {
						player.stand();
						askQuestion();
						System.out.println("Overlapping OVERHANG");
					}
				}
			}
		}
	}
}

