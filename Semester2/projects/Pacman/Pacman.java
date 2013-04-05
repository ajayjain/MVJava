// Ajay Jain
// March 4, 2013
// Pacman.java
// This is a simplified version of Pacman, where you try to eat all the cheese and avoid the monsters.

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Pacman {
	byte[][][] board;	// Holds counts of cheese and monsters at each spot on a 10 by 10 board
	byte[] pacman;			// Data about pacman: [row, col, mouthAngle]
	boolean isOpeningMouth, isDead, isWinner;	// booleans tracking state of pacman
	JFrame frame;	// Main frame for game
	GamePanel panel;	// JPanel containing all the content
	Timer monsterTimer, pacmanTimer;	// Hold the timers for the game
	byte cheese;	// Counts how much cheese is on the board
	Font endFont;
	
	public static void main(String[] args) {
		Pacman game = new Pacman();
		game.run();
	}
	
	// Starting point for game
	public void run() {
		board = new byte[10][10][2];			//format of string: "cheesecount-monstercount" ("12" - 1 cheese, 2 monsters)
		isOpeningMouth = isDead = isWinner = false;
		cheese = 6;
		pacman = new byte[3];
		endFont = new Font("Helvetica", Font.PLAIN, 60);
		
		placeStuff(1);
		placeStuff(2);
		//System.out.println(java.util.Arrays.deepToString(board));
		
		frame = new JFrame("Pacman");
		panel = new GamePanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	// add panel to frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setSize(481, 523);		// explicitly set size in pixels
		frame.setResizable(false);
		frame.setVisible(true);		// set to false to make invisible
	}
		
	// Place monsters, cheese and pacman randomly on the board
	public void placeStuff(int statusIndex) {
		Random rand = new Random();
		for (int count = 0; count < 6; count++) {
			int x, y;
			switch (statusIndex) {
				case 1:
					// mark random cheese while not on unique square
					do {
						x = rand.nextInt(10);
						y = rand.nextInt(10);
					} while (board[x][y][0] > 0);
					board[x][y][0] = 1;
					break;
				case 2:
					// mark random monster
					x = rand.nextInt(10);
					y = rand.nextInt(10);
					board[x][y][1]++;
			}
		}
		// mark random pacman
		byte x, y;
		do {
			x = (byte) rand.nextInt(10);
			y = (byte) rand.nextInt(10);
		} while (board[x][y][1] > 0); // while on top of a monster
		pacman[0] = x;
		pacman[1] = y;
	}
		
	// Main panel/canvas for game
	class GamePanel extends JPanel implements KeyListener {
		public GamePanel() {
			super();
			frame.addKeyListener(this);
			
			// Initialize a timer to move monsters at 1 second intervals
			monsterTimer = new Timer(1000, new MonsterLoop());
			monsterTimer.start();
			
			// Start off with a 40 degree mouth angle
			pacman[2] = 40;
			pacmanTimer = new Timer(5, new PacmanLoop());
			pacmanTimer.start();
		}
	
		// Calls drawing methods
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawBackground(g);
			drawGrid(g);
		}
		
		// Draws the backgrounds and instructions
		public void drawBackground(Graphics g) {
			setBackground(Color.blue);
			
			// Fill rect for board outline
			g.setColor(Color.lightGray);
			g.fillRect(15, 15, 439, 439);
			
			// Bottom red rect for instructions
			g.setColor(Color.red);
			g.fillRect(0, 470, 500, 30);
			g.setColor(Color.black);
			g.drawString("Directions: a = left, d = right, w = up, s = down, r = reset", 55, 485);
		}
		
		// Draws white squares, cheese, pacman and monsters
		public void drawGrid(Graphics g) {
			for (int row = 0; row < 10; row++) {
				for (int col = 0; col < 10; col++) {
					byte[] status = board[row][col];
					int y = 43*row+20,
						x = 43*col+20;
					//System.out.printf("%d %d %s\n", row, col, status);
					// Draw white square
					g.setColor(Color.white);
					g.fillRect(x, y, 40, 40);
					if (status[0] > 0) {
						//if pacman is on this spot
						if (pacman[0] == row && pacman[1] == col) {
							board[row][col][0]--;
							// if all cheese is eaten, we have a winner!
							if (--cheese < 1)
								isWinner = true;
						} else {
							//Draw cheese square
							g.setColor(Color.yellow);
							g.fillRect(x+2, y+2, 36, 36);
						}
					}
					if (status[1] > 0) {
						// Draw monster head
						g.setColor(Color.red);
						g.fillOval(x, y, 40, 40);
						// Draw eyes
						g.setColor(Color.black);
						g.fillOval(x+10, y+13, 6, 6);
						g.fillOval(x+24, y+13, 6, 6);
						// Draw mouth
						g.drawLine(x+10, y+30, x+30, y+30);
						
						if (pacman[0] == row && pacman[1] == col)
							isDead = true; // Pacman dies!
					}
					// Draw pacman with either wide or narrow mouth depending on pacman[2]
					y = 43*pacman[0]+20;
					x = 43*pacman[1]+20;
					g.setColor(Color.blue);
					g.fillArc(x, y, 40, 40, pacman[2], 360-2*pacman[2]);
				}
			}
			if (isWinner) {
				stopTimers();
				g.setColor(Color.blue);
				g.setFont(endFont);
				g.drawString("YOU WIN!" , 105, 250);
			}
			if (isDead) {
				stopTimers();
				g.setColor(Color.red);
				g.setFont(endFont);
				g.drawString("YOU LOSE!", 100, 250);	// Draw at end so a white square doesn't overlap it
			}
		}
		
		// Stop monster movement and pacman mouth timers
		public void stopTimers() {
			monsterTimer.stop();
			pacmanTimer.stop();
		}
		
		// update pacman location, params are change in location
		public void movePacman(int drow, int dcol) {
			if (!isWinner && !isDead) {
				// go to the other side of the board if pacman passes the edge
				int nrow = (pacman[0] += drow) % 10,
					ncol = (pacman[1] += dcol) % 10;
				if (nrow == -1) nrow = 9;
				if (ncol == -1) ncol = 9;
				
				pacman[0] = (byte) nrow;
				pacman[1] = (byte) ncol;
			}
		}
		
		// Decide what to do when a key is pressed
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyChar()) {
				case 'r':
					// Restart game
					stopTimers();
					frame.dispose();
					run(); break;
				case 'w': movePacman(-1, 0); break;
				case 'a': movePacman(0, -1); break;
				case 's': movePacman(1, 0); break;
				case 'd': movePacman(0, 1);
			}
			repaint();
		}
		
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}

	class MonsterLoop implements ActionListener {
		// Move monster in the cardinal directions
		public void actionPerformed(ActionEvent e) {
			for (byte row = 0; row < 10; row++) {
				for (byte col = 0; col < 10; col++) {
					byte[] status = board[row][col];
					// if there are monsters
					if (status[1] > 0)
						for (byte mon = 0; mon < status[1]; mon++) {
							Random randGenerator = new Random();
							byte newrow = row, newcol = col;
							// Move monster
							do {
								byte randNum = (byte) (randGenerator.nextInt(3)-1); // random number in set {-1,0,1}
								if (Math.random() >= .5)
									newrow += randNum;
								else
									newcol += randNum;
							} while(newrow > 9 || newrow < 0 || newcol > 9 || newcol < 0); // ensure new position is on board
							// remove monster from board
							board[row][col][1]--;
							// add new monster to board
							board[newrow][newcol][1]++;
						}
				}
			}
			panel.repaint();
		}
	}
	
	class PacmanLoop implements ActionListener {
		// Animate pacman's mouth
		public void actionPerformed(ActionEvent e) {
			if (isOpeningMouth) {
				pacman[2]++;
				// Start CHOMP
				if (pacman[2] >= 40) isOpeningMouth = false;
			} else {
				pacman[2]--;
				// Breathe for air
				if (pacman[2] <= 0) isOpeningMouth = true;
			}
			panel.repaint();
		}
	}
}
