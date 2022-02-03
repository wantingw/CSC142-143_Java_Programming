package empirical;

public class PerformanceTest {

	public static int[] dataSet(int n) {
		long startTime = System.currentTimeMillis();
		
		//just some tom foolery 
		int[] data = new int[n];
		
		//begin: tom foolery 
		for (int i = 0; i < n; i++) {
			data[i] =  i + 105;
		}
		
		long endTime   = System.currentTimeMillis();
		
		System.out.print("DataSet:  n = " + n + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
		return data;
	}
	

	public static int findRange_01(int[] data) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				diff = Math.abs(data[j] - data[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	

	public static int findRange_02(int[] data) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j =  i + 1; j < data.length; j++) {
				diff = Math.abs(data[j] - data[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	

	public static int findRange_03(int[] data) {
		int max = data[0];
		int min = max;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
				
			} else if(data[i]< min){
				min = data[i];
			}
		}
		return max - min;
	}
	

	public static void timeRange_01(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = findRange_01(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	

	public static void timeRange_02(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = findRange_02(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}

	
	public static void timeRange_03(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = findRange_03(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	

	public static void main(String[] args) {
		
		System.out.println("Data Set - 1 to 8");
		int[] data1  = dataSet(1000);
		int[] data2  = dataSet(5000);
		int[] data3  = dataSet(10000);
		int[] data4  = dataSet(25000);
		int[] data5  = dataSet(50000);
		int[] data6  = dataSet(75000);
		int[] data7  = dataSet(100000);
		int[] data8  = dataSet(125000);
		int[] data9  = dataSet(250000);
		int[] data10 = dataSet(500000);
		
		System.out.println();
		System.out.println("Range 1 - Run Time Analysis");
		timeRange_01(data1);
		timeRange_01(data2);
		timeRange_01(data3);
		timeRange_01(data4);
		timeRange_01(data5);
		timeRange_01(data6);
		timeRange_01(data7);
		timeRange_01(data8);
		timeRange_01(data9);
		timeRange_01(data10);
		
		
		System.out.println();
		System.out.println("Range 2 - Run Time Analysis");
		timeRange_02(data1);
		timeRange_02(data2);
		timeRange_02(data3);
		timeRange_02(data4);
		timeRange_02(data5);
		timeRange_02(data6);
		timeRange_02(data7);
		timeRange_02(data8);
		timeRange_02(data9);
		timeRange_02(data10);
		
		System.out.println();
		System.out.println("Data Set - 9 to 18 for Range 3");

		int[] data11 = dataSet(10000000);
		int[] data12 = dataSet(20000000);
		int[] data13 = dataSet(40000000);
		int[] data14 = dataSet(60000000);
		int[] data15 = dataSet(80000000);
		int[] data16 = dataSet(100000000);
		int[] data17 = dataSet(125000000);
		int[] data18 = dataSet(150000000);
		int[] data19 = dataSet(200000000);
		int[] data20 = dataSet(250000000);
		
		System.out.println();
		System.out.println("Range 3 - Run Time Analysis");
		timeRange_03(data1);
		timeRange_03(data2);
		timeRange_03(data3);
		timeRange_03(data4);
		timeRange_03(data5);
		timeRange_03(data6);
		timeRange_03(data7);
		timeRange_03(data8);
		timeRange_03(data9);
		timeRange_03(data10);
		timeRange_03(data11);
		timeRange_03(data12);
		timeRange_03(data13);
		timeRange_03(data14);
		timeRange_03(data15);
		timeRange_03(data16);
		timeRange_03(data17);
		timeRange_03(data18);
		timeRange_03(data19);
		timeRange_03(data20);
	 }

}
