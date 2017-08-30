package source;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DetetectMove {
	
	public static void main(String[] args) {
		
		File file1 = new File("dog1.jpg");
		File file2 = new File("dog2.jpg");
		
		BufferedImage image1 = null;
		BufferedImage image2 = null;
		
		try {
			image1 = ImageIO.read(file1);
			image2 = ImageIO.read(file2);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int width = image1.getWidth();
		int height = image1.getHeight();
		
		BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				Color color1 = new Color(image1.getRGB(i, j));
				Color color2 = new Color(image2.getRGB(i, j));
				
				int r1 = color1.getRed();
				int r2 = color2.getRed();
				
				int g1 = color1.getGreen();
				int g2 = color2.getGreen();
				
				int b1 = color1.getBlue();
				int b2 = color2.getBlue();
				
				int r = (r1 - r2+255)/2;
				int g = (g1 - g2+255)/2;
				int b = (b1 - b2+255)/2;
			
				
				finalImage.setRGB(i, j, new Color(r, g, b).getRGB());
				
			}
		}
		
		try {
			ImageIO.write(finalImage, "jpg", new File("final_dog.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
