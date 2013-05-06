// Fetch image from array, or immediately load requested image
	private Image getImage(byte index) {
		if (images == null) images = new Image[imageNames.length];
		// Do not load cover and prevent image from being reloaded
		// if (index != 0 && images[index] == null) {
		// 	// Stop thread from loading this image
		// 	loadingIndex = index;
		// 	String imageName = imageNames[index];
		// 	// try-catch block for loading the image
		// 	try {
		// 		images[index] = ImageIO.read(new File(imageName));
		// 		System.out.printf("Me.getImage: Loaded %s into images[%d]\n", imageName, index);
		// 	} catch (IOException e) {
		// 		System.err.println("ERROR: File not found - "+imageName);
		// 		System.exit(1);
		// 	}
		// }
		return images[index];
	}


// private byte[] loadingIndicies = {0, 0};	// {image loading in thread, image loading in getImages}

	/*&& imageIndex != loadingIndex*/

	//System.out.println(images[imageIndex].toString());