import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Main {

	public static void main(String[] args) {
		ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName("png").next();
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
					BufferedImage second_image = new BufferedImage(image.getWidth(), image.getHeight(), 
							BufferedImage.TYPE_INT_ARGB);
					for(int k = 0; k < image.getWidth(); k++) {
						for(int l = 0; l < image.getHeight(); l++) {
							if(rgb == image.getRGB(k, l)) {
								second_image.setRGB(k, l, color.getRGB());
							} else {
								second_image.setRGB(k, l, image.getRGB(k, l));
							}
						}
					}
					ImageIO.write(second_image, "png", new File("gifs/corki_"+i+".png"));
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
