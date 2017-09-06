package op_geometricas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ampliacao {

	public static void main(String[] args) {
		semReplicacao();
		comReplicacao();
	}
	
	public static void semReplicacao () {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("dog1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if (image != null) {
			int width = image.getWidth();
			int height = image.getHeight();
			
			BufferedImage ampliadaSemEfeito = new BufferedImage(2*width, 2*height, BufferedImage.TYPE_INT_RGB);
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int rgb = image.getRGB(i, j);
					ampliadaSemEfeito.setRGB(i*2, j*2, rgb);
				}
			}
			try {
				ImageIO.write(ampliadaSemEfeito, "jpg", new File("ampliadaSemEfeito.jpg"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	public static void comReplicacao () {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("dog1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if (image != null) {
			int width = image.getWidth();
			int height = image.getHeight();
			
			BufferedImage ampliadaComEfeito = new BufferedImage(2*width, 2*height, BufferedImage.TYPE_INT_RGB);
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int rgb = image.getRGB(i, j);
					ampliadaComEfeito.setRGB(i*2, j*2, rgb);
					 for (int x = 0; x < 2; x++) 
						 for (int y = 0; y<2; y++) 
							 ampliadaComEfeito.setRGB((i*2)+x,(2*j)+y, rgb); 
				}
			}
			try {
				ImageIO.write(ampliadaComEfeito, "jpg", new File("ampliadaComEfeito.jpg"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
