import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Num1 {

	public static void main(String[] args) {
		File file = new File("angel.jpg");
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if(image != null) {
			int w = image.getWidth();
			int h = image.getHeight();
			
			for(int i = 0; i<w; i++) {
				for(int j = 0; j<h; j++) {
					
					Color color = new Color(image.getRGB(i, j));
					
					int r = color.getRed();
					
					Color finalColor = new Color(r, 0, 0);
					image.setRGB(i, j, finalColor.getRGB());
					
				}
			}
			
			try {
				ImageIO.write(image, "jpg", new File("angelRed.jpg"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
