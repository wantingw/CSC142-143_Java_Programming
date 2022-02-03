package sequence;

public class SequenceClient {
	
	/************************************************************
	 * returns the result of a factorial down to zero factorial
	 * @param n  positive integer and zero
	 * @throws IllegalArgumentException for negative numbers.
	 * @return compiled result.
	 * **********************************************************/
	public static int fac(int n) {
		//TODO: COMPLETE BODY
		return 0;
	}
	
	/***********************************************************
	 * returns the result of the memoization sequence of numbers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * @return compiled result.
	 * *********************************************************/
	public static int fib(int n) {
		//TODO : COMPLETE BODY
		return 0;
	}
		
	/***********************************************************
	 * returns the result of a double precision floating point 
	 * number x to the nth power.
	 * @param x double precision floating point number
	 * @param n integer
	 * @throws IllegalArgumentException for negative exponents.
	 * @return compiled result.
	 * *********************************************************/
	public static double pow(double x, int n) {
		//TODO: COMPLETE BODY
		return 0;
	}
	
	/***********************************************************
	 * returns the result of the sum of n integers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * @return compiled result.
	 * *********************************************************/
	public static int sum(int n) {
		//TODO : COMPLETE BODY
		return 0;
	}
	
	
	/***********************************************************
	 * runs the program
	 * @param args program arguments
	 * *********************************************************/
	public static void main(String[] args) {
		
		int n = 5;
		
		//count of nth factorial
		System.out.println("------------- nth factorial --------------");
		for (int i = 0; i <= n; i++ ) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//value for nth factorial 
		for (int i = 0; i <= n; i++ ) {
			System.out.print(fac(i) + "\t");
		}
		System.out.println();
		
		n = 4;
		System.out.println();
		System.out.println("-------------- sum(n) -------------");
		
		//summation of n integers
		int sum = n * (n + 1) / 2;
		System.out.println("sum of " + n + " integers: " + sum);
		System.out.println("sum of " + n + " integers: " + sum(n));
		
		//two to the power of  n
		n = 16;
		double two$n = Math.pow(2, n);
		System.out.println();
		System.out.println("-------------- pow(2, n) -------------");
		System.out.println("pow(2, n): " + n + " gives " + two$n);
		System.out.println("pow(2, n): " + n + " gives " + pow(2, n));
		System.out.println();
		
		//e to the power of  n
		n = 8;
		double x$n = Math.pow(Math.E, n);
		System.out.println("-------------- pow(x,n) -------------");
		System.out.println("x(n):      " + n + " gives " + x$n);
		System.out.println("pow(e, n): " + n + " gives " + pow(Math.E, n));
		
	}

}
