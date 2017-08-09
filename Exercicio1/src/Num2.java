import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Num2 {

	public static void main(String[] args) {
		File file = new File("rose.png");
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if(image != null) {
			int width = image.getWidth();
			int height = image.getHeight();
			
			for(int i = 0; i < width; i++) {
				for(int k = 0; k < height; k++) {
					
					Color color = new Color(image.getRGB(i, k));
					
					int r = color.getRed();
					int g = color.getGreen();
					int b = color.getBlue();
					
					int avg = (r + g + b)/3;
					
					Color newColor = new Color(avg, avg, avg);
					
					image.setRGB(i, k, newColor.getRGB());
					
				}
			}
		}
		
		try {
			ImageIO.write(image, "png", new File("greyRose.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
 	}

}
