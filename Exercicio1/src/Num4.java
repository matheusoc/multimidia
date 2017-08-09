import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Num4 {

	public static void main(String[] args) {
		File file = new File("redRose.png");
		
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
					
					if(!(r ==  g && r == b)) {
						Color newColor = new Color(0, r, 0);
						
						image.setRGB(i, k, newColor.getRGB());
					}
					
				}
			}
		}
		
		try {
			ImageIO.write(image, "jpeg", new File("greenRose.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
