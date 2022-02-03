package empirical;

public class FibonacciTest {

	static int count =  0;

	/***********************************************************
	 * returns the result of a Fibonacci Sequence.
	 * 
	 * @param n integer of the Fibonacci Sequence.
	 * @return result with expanded space for larger integers.
	 *********************************************************/
	public static long fib(int n) {
		count++;
		if (n == 0 || n == 1) {
			return n;
		}else
			return fib(n - 1) + fib(n - 2);
	}

	/***********************************************************
	 * returns a dynamic result of a Fibonacci Sequence.
	 * 
	 * @param n integer of the Fibonacci Sequence.
	 * @return result with expanded space for larger integers.
	 ***********************************************************/
	public static long m_fib(int n) {
		long[] m = new long[n + 1];

		return m_fib(n, m);
	}

	/***********************************************************
	 * returns a dynamic result of a Fibonacci Sequence.
	 * 
	 * @param n integer of the Fibonacci Sequence.
	 * @param m integer array store values
	 * @return result with expanded space for larger integers.
	 ***********************************************************/
	private static long m_fib(int n, long[] m) {

		boolean isEmpty = n > 1 && m[n] == 0;

		if (n == 0 || n == 1)
			m[n] = n;
		else if (isEmpty)
			m[n] = m_fib(n - 1, m) + m[n - 2];
		return m[n];

	}

	/***********************************************************
	 * returns a iterative d result of Fibonacci Sequence.
	 * 
	 * @param n integer of the Fibonacci Sequence.
	 * @return iteration result of Fibonacci Sequence.
	 ***********************************************************/
	public static long i_fbn(int n) {

		if (n == 0 || n == 1) {
			return n;
		} else {
			long f_n1 = 0;
			long f_n2 = 1;
			long f_n = 0;

			for (int i = 1; i <= n; i++) {
				f_n = f_n1 + f_n2;
				f_n2 = f_n1;
				f_n1 = f_n;
			}
			return f_n;
		}
	}

	/***********************************************************
	 * Use to print out the result of each algorithm
	 * 
	 * @param name String of the each algorithm method
	 * @param n    integer of the Fibonacci Sequence
	 ***********************************************************/
	public static void printer(String name, int n) {
		System.out.print(name);
		System.out.println("\n---------------------------------------------------------------------------");
		for (int i = 0; i <= n; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();

		// value for nth factorial
		for (int i = 0; i <= n; i++) {
			if (name.equals("Algorithm-1 :fib(n)")) {
				System.out.print(fib(i) + "\t");
			} else if (name.equals("Algorithm-2 : memorize fib(n)")) {
				System.out.print(m_fib(i) + "\t");
			} else if (name.equals("Algorithm-3 : iterate fib(n)")) {
				System.out.print(i_fbn(i) + "\t");
			}
		}

		System.out.println("\n \n");

	}

	/***********************************************************
	 * Performance test for fib(n) method
	 ***********************************************************/
	public static void timeFib_01(int n) {
		long startTime = System.nanoTime();
		fib(n);
		long endTime = System.nanoTime();
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}

	/***********************************************************
	 * Performance test for memorize fib(n) method
	 ***********************************************************/
	public static void timeFib_02(int n) {
		long startTime = System.nanoTime();
		m_fib(n);
		long endTime = System.nanoTime();
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}

	/***********************************************************
	 * Performance test for iteration fbn(n) method
	 ***********************************************************/
	public static void timeFib_03(int n) {
		long startTime = System.nanoTime();
		i_fbn(n);
		long endTime = System.nanoTime();
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}

	public static void main(String[] args) {
		int n = 9;

		printer("Algorithm-1 :fib(n)", n);

		printer("Algorithm-2 : memorize fib(n)", n);

		printer("Algorithm-3 : iterate fib(n)", n);

		count = 0;
		fib(n);

		System.out.println("Fib. Calls: " + count);
		System.out.println();

		System.out.println("Run time for Alhorith-1 fib(n)");
		for (int i = 27; i < 50; i += 3) {
			timeFib_01(i);
		}
		System.out.println();

		System.out.println("Run time for Alhorith-2 memorize fib(n)");
		for (int i = 30; i < 110; i += 10) {
			timeFib_02(i);
		}
		System.out.println();

		System.out.println("Run time for Alhorith-3 iteration fib(n)");
		for (int i = 30; i < 110; i += 10) {
			timeFib_03(i);
		}
		System.out.println();

	}

}
