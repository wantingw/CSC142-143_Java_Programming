package modules;

public class SearchTest {
	public static void main(String[] args) {
		int[] data = {2, 9, 4, 5, 8, 1, 6};
		
		int[] b_data = {1, 2, 4, 5, 6, 7, 8, 9};
		
		System.out.println("------------ ### linear Index -----------");
		System.out.println("Location of 8-> " + ArrayModule.indexOf(data,8));
		System.out.println("Location of 9-> " + ArrayModule.indexOf(data,9));
		System.out.println("Location of 7-> " + ArrayModule.indexOf(data,7));
		System.out.println("------------ ### linear Contain ----------");
		System.out.println("Location of 8-> " + ArrayModule.contains(data,8));
		System.out.println("Location of 9-> " + ArrayModule.contains(data,9));
		System.out.println("Location of 7-> " + ArrayModule.contains(data,7));
		System.out.println("------------ ### Binary Search -----------");
		System.out.println("Location of 8-> " + ArrayModule.binarySearch(b_data,8));
		System.out.println("Location of 2-> " + ArrayModule.binarySearch(b_data,2));
		System.out.println("Location of 3-> " + ArrayModule.binarySearch(b_data,3));
		System.out.println("------------ ### Recursive Binary Search -");
		System.out.println("Location of 8-> " + ArrayModule.recBinarySearch(b_data,8));
		System.out.println("Location of 2-> " + ArrayModule.recBinarySearch(b_data,2));
		System.out.println("Location of 3-> " + ArrayModule.recBinarySearch(b_data,3));
		System.out.println("------------ ### bubble sort -------------");
		ArrayModule.bubbleSort(data);
		System.out.println(data);
	}
	
}
