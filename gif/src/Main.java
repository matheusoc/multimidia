import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Main {

	public static void main(String[] args) {
		ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName("gif").next();
		ImageInputStream iss = null;
		try {
			iss = ImageIO.createImageInputStream(new File("corki.gif"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(iss != null) {
			reader.setInput(iss);
			
			try {
				int noi = reader.getNumImages(true);
				
				for(int i = 0; i < noi; i++) {
					BufferedImage image = reader.read(i);
					ImageIO.write(image, "jpg", new File("corki_" + i + ".jpg"));
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
