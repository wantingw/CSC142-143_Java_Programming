// Write your short report here (-2 if there is no report)

// Group Member: Dian Yang, Wan-ting Wu
// Besides the simple transformations and the four 3x3 transformations,
// we also tried other transformations like BlackAndWhite, Darker, Emboss and so on,
// most of them works, but some classes like Whiter does not reach the expected effect.
// I would like to list out the problems and the surprise we encounter during programming. 
// 1.We find that if we set data[i][j]red, data[i][j]blue, and data[i][j]green equal to data[i][j]green, 
// the running result is same as our current BlackAndWhite.java result. It's interesting to know this, 
// even though we didn't figure out why they have the same result.
// 2.We tried to reverse the algorithms in Darker.java to make the image get Whiter, 
// but it fails! It becomes nearly a pure blue image instead of white. 
// 3.After we created BlackAndWhite.java, we tried to create a filter that able to smooth the image.
// But it seems like our Smooth.java has the same result as the GaussianFilter.java. 
// We also combined the Black and White effect with smooth, and it works fine.

/**
 * A class to configure the SnapShop application
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration {
	/**
	 * Method to configure the SnapShop. Call methods like addFilter and
	 * setDefaultFilename here.
	 * 
	 * @param theShop
	 *            A pointer to the application
	 */
	public static void configure(SnapShop theShop) {

		theShop.setDefaultFilename("billg.jpg");
		
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		// add your other filters below
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		
		theShop.addFilter(new NegativeFilter(), "Negative");
		
		theShop.addFilter(new GaussianFilter(), "Gaussian");
		
		theShop.addFilter(new LaplacianFilter(), "Laplacian");
		
		theShop.addFilter(new UnsharpMaskingFilter(), "UnsharpMasking");
		
		theShop.addFilter(new EdgyFilter(), "Edgy");
		
		theShop.addFilter(new BlackAndWhite(), "Black and White");
		
		theShop.addFilter(new BlackAndWhiteAndSmooth(), "Smooth black& white");
		
		theShop.addFilter(new ReverseColor(), "Reverse Color");
		
		theShop.addFilter(new Smooth(), "Smooth");
		
		theShop.addFilter(new Darker(), "Darker");
		
		theShop.addFilter(new Exposure(), "Exposure");
		
		theShop.addFilter(new Emboss(), "Emboss");
		
		theShop.addFilter(new Sepia(), "Sepia");
		
		theShop.addFilter(new Diffuse(), "Diffuse");
		
		
		
	}
}
