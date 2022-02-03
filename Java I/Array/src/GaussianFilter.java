
public class GaussianFilter implements Filter {

	@Override
	public void filter(PixelImage pi) {
		int[][] weights = {{1,2,1},{2,4,2},{1,2,1}};
		//transformImages is where the computation of the 
		// new pixels is done
		pi.imageTransformation(weights);
	}
	
}
