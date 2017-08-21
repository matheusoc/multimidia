package source;

public class Main {
	
	private static void rgb_to_cmyk(float r, float g, float b) {
		
		float r_linha = r/255;
		float g_linha = g/255;
		float b_linha = b/255;
		
		float c;
		float m;
		float y;
		
		float k = 1 - Math.max(b_linha, Math.max(r_linha, g_linha));
		
		if(k == 1) {
			c = 0; m = 0; y = 0;
		} else {
			c = (1 - r_linha - k)/(1-k);
			m = (1 - g_linha - k)/(1-k);
			y = (1 - b_linha - k)/(1-k);
		}
		 
		
		System.out.println("Valor c " + c+"\n"
						+ "Valor m " + m+"\n"
						+ "Valor y " + y+"\n"
						+"Valor k " + k+"\n");
		
	}
	
	private static void rgb_to_hsv(float r, float g, float b) {
		
		float r_linha = r/255;
		float g_linha = g/255;
		float b_linha = b/255;
		
		float cMax = Math.max(b_linha, Math.max(r_linha, g_linha));
		float cMin = Math.min(b_linha, Math.min(r_linha, g_linha));
		
		float delta = cMax - cMin;
		
		float h = 0, s;
		
		if (delta == 0) {
			h = 0;
		} else if (cMax == r_linha) {
			h = 60 * (((g_linha - b_linha)/delta) % 6);
		} else if (cMax == g_linha) {
			h = 60 * (((b_linha - r_linha)/delta) + 2);
		} else if (cMax == b_linha) {
			h = 60 * (((r_linha - g_linha)/delta) + 4);
		}
		
		if (cMax == 0) {
			s = 0;
		} else {
			s = delta/cMax;
		}
		
		System.out.println("Valor h " + h+"\n"
						+ "Valor s " + s+"\n"
						+ "Valor v " + cMax+"\n");
		/*float[] colors = Color.RGBtoHSB(r, g, b, null);
		
		for(float color: colors) {
			System.out.println(color);
		}*/
	}
	
	public static void main(String[] args) {
		
		rgb_to_hsv(40, 136, 2);
		
		rgb_to_cmyk(40, 136, 2);
	}

}
