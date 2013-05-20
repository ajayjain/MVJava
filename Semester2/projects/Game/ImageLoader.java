// Ajay Jain
// May 11, 2013
// ImageLoader.java
// Class to load images from disk.

import java.io.File;
import java.io.IOException;

import java.awt.Image;
import javax.imageio.ImageIO;

public class ImageLoader extends Thread {
	// Blocks and objects
	public Image
		rock,
		spikes,
		roots,
		stoneBlock,
		grassDirtBlock,
		darkGrassDirtBlock,
		stonePathBlock;

	// Backgrounds
	public Image swampBackground, desertBackground, starBackground;
	
	public void run() {
		rock = loadBlock("rock");
		spikes = loadBlock("spikes");
		roots = loadBlock("roots");
		stoneBlock = loadBlock("stoneBlock");
		grassDirtBlock = loadBlock("grassDirtBlock");
		darkGrassDirtBlock = loadBlock("darkGrassDirtBlock");
		stonePathBlock = loadBlock("stonePathBlock");
		
		// starBackground = loadBackground("stars");
		// swampBackground = loadBackground("swamp");
		// desertBackground = loadBackground("desert");
	}
	
	public Image load(String fileName) {
		Image im = null;
		try {
			im = ImageIO.read(new File(fileName));
			System.out.println("Loaded "+fileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return im;
	}

	public Image loadBlock(String block) {
		return load("images/blocks/"+block+".png");
	}

	public Image loadBackground(String back) {
		return load("images/back/"+back+".png");
	}
}
