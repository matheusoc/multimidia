package op_geometricas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Espelhamento {

	public static void main(String[] args) {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("dog1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		if (image != null) {
			int width = image.getWidth();
			int height = image.getHeight();
			
			BufferedImage espelhada = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int rgb = image.getRGB(i, j);
					espelhada.setRGB(width - i -1, j, rgb);
				}
			}
			try {
				ImageIO.write(espelhada, "jpg", new File("espelhada.jpg"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
