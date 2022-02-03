
public class UnsharpMaskingFilter implements Filter {

	@Override
	public void filter(PixelImage pi) {
		// TODO Auto-generated method stub
		int[][] weights = {{-1, -2, -1},{-2, 28, -2},{-1,-2,-1}};
		pi.imageTransformation(weights);
	}
	

}