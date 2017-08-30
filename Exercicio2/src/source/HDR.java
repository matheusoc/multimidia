package source;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class HDR {
	
	public static ArrayList<BufferedImage> getImages () {
		File file1 = new File("h1.JPG");
		File file2 = new File("h2.JPG");
		File file3 = new File("h3.JPG");
		File file4 = new File("h4.JPG");
		
		ArrayList<BufferedImage> images = new ArrayList<>();
		try {
			images.add(ImageIO.read(file1));
			images.add(ImageIO.read(file2));
			images.add(ImageIO.read(file3));
			images.add(ImageIO.read(file4));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return images;
	}

	/**
	 * Código feito baseando que todas as imagens possuem o mesmo tamanho
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<BufferedImage> images = getImages();
		
		int width = images.get(0).getWidth();
		int height = images.get(0).getHeight();
		
		BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int size = images.size();
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int r = 0;
				int g = 0;
				int b = 0;
				for (int k = 0; k < size; k++) {
					Color color = new Color(images.get(k).getRGB(i, j)); 
					r += color.getRed();
					g += color.getGreen();
				    b += color.getBlue();
				}
				
				Color color = new Color(r/size, g/size, b/size);
				finalImage.setRGB(i, j, color.getRGB());
				
			}
		}
		
		try {
			ImageIO.write(finalImage, "JPG", new File("final.JPG"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
