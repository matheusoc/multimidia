import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import com.sun.imageio.plugins.gif.GIFImageReader;

public class Main {

	public static void main(String[] args) {
		GIFImageReader reader = (GIFImageReader) ImageIO.getImageReadersByFormatName("gif").next();
		ImageInputStream iss = null;
		
		try {
			iss = ImageIO.createImageInputStream(new File("corki.gif"));
			reader.setInput(iss);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int rgb = 0, r, g, b;
		Color c = null, color = null;
		try {
			rgb = reader.read(0).getRGB(0, 0);
			c = new Color(rgb);
			r = c.getRed();
			g = c.getGreen();
			b = c.getBlue();
			color = new Color(r, g, b, 0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if(iss != null) {
			try {
				int noi = reader.getNumImages(true);
				
				for(int i = 0; i < noi; i++) {
					BufferedImage image = reader.read(i);
					for(int k = 0; k < image.getWidth(); k++) {
						for(int l = 0; l < image.getHeight(); l++) {
							if(rgb == image.getRGB(k, l)) {
								image.setRGB(k, l, color.getRGB());
							}
						}
					}
					ImageIO.write(image, "png", new File("C:/Users/MatheusdeOliveiraCam/Desktop/gif/corki_" + i + ".png"));
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
