
public class NegativeFilter implements Filter{
	
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		for (int i=0; i< pi.getHeight(); i++) {
			for (int j=0; j<pi.getWidth(); j++) {
				// change the color in the negative one
				// set color negative
				data[i][j].red = 255-data[i][j].red;
				data[i][j].green = 255-data[i][j].green;
				data[i][j].blue = 255-data[i][j].blue;
				
				
				
			}
		}
		pi.setData(data);
		
	}

}