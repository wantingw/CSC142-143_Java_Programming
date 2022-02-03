package modules;

public class ArrayModule {

	public static int indexOf (int[] data, int target) {		
		for (int i = 0; i < data.length; i++) {
			if (data[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean contains (int[] data, int target) {
		return indexOf(data, target) != -1;
	}
	
	public static int binarySearch (int[] data, int target) {
		int min = 0;
		int max = data.length - 1;
		int mid;
		while(max >= min ){
			mid = (min + max) / 2;
			if (data[mid] < target) {
				min = mid + 1;
			}
			else if (data[mid] > target){
				max = mid - 1;
			}else 
				return mid;
			}
	return -1;
	}
	
	 // recursive binary search
	public static int recBinarySearch(int[] data, int target,int min, int max) {
		if (min > max) {
			return -1;
		}else {
			int mid = (min + max) / 2;
			if (data[mid] < target) {
				return recBinarySearch(data, target, mid+1, max);
			}else if (data[mid] > target) {
				return recBinarySearch(data, target, mid, max-1);
			}else {
				return mid;
			}
		}
	}


	public static int recBinarySearch(int[] data, int target) {
		return recBinarySearch(data, target, 0, data.length - 1);
	}
	
	public static void swap(int[] data, int first, int second) {
		int temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	
}
	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length - 1; j++ ) {
				if (data[j] < data[j - 1]) {
					swap(data, j-1, j);
				}
			}
		}
	}

	public static void selectionSort(int[] data) {
		int minIndex;
		for (int i = 0; i < data.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int min 		 = data[minIndex];
				data[minIndex] 	 = data[i];
				data[i]			 = min;
			}
		}
	}
	
	public static void insertionSort(int[] data) {

		int current;
		int j;
		for (int i = 1; i < data.length; i++) {
			current = data[i];
			for (j = i; j > 0 && current < data[j - 1]; j--) {
				data[j] = data[j - 1];
			}
			data[j] = current;
		}
	}
	
	

}