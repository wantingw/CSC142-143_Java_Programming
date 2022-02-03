
public class LaplacianFilter implements Filter {

	@Override
	public void filter(PixelImage pi) {
		
		// TODO Auto-generated method stub
		int[][] weights = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
		pi.imageTransformation(weights);
	}
	

}
