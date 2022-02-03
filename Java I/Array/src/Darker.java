public class Darker implements Filter {

	@Override
	public void filter(PixelImage pi) {

		Pixel[][] data = pi.getData();
		for (int i = 0; i < pi.getHeight(); i++) {
			for (int j = 0; j < pi.getWidth(); j++) {
				// set the rgb in the same value
				data[i][j].red = (data[i][j].red) - 10;
				data[i][j].green = (data[i][j].green) - 10;
				data[i][j].blue = (data[i][j].blue) - 10;
				if (data[i][j].red < 0) {
					data[i][j].red = 0;
				}
				if (data[i][j].green < 0) {
					data[i][j].green = 0;
				}
				if (data[i][j].blue < 0) {
					data[i][j].blue = 0;
				}
			}
		}
		pi.setData(data);
	}
}