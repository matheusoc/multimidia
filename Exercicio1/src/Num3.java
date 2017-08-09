import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Num3 {
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
					
					double difrg = Double.valueOf(r)/Double.valueOf(g);
					double difrb = Double.valueOf(r)/Double.valueOf(b);
					
					if (difrg < 1.6) {
						double l = (0.21*Double.valueOf(r) + 0.7*Double.valueOf(g) + 0.07*Double.valueOf(b));
						
						int luminosity = (int) l;
						
						Color newColor = new Color(luminosity, luminosity, luminosity);
						
						image.setRGB(i, k, newColor.getRGB());
					}
					
					else if (difrb < 1.5) {
						double l = (0.21*Double.valueOf(r) + 0.7*Double.valueOf(g) + 0.07*Double.valueOf(b));
						
						int luminosity = (int) l;
						
						Color newColor = new Color(luminosity, luminosity, luminosity);
						
						image.setRGB(i, k, newColor.getRGB());
					}
					
				}
			}
		}
		
		try {
			ImageIO.write(image, "jpeg", new File("redRose.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
