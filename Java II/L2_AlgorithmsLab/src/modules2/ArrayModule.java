package modules2;

public class ArrayModule {
	
	private static int[] firstHalf(int[] data) {

		int middle;
		if (data.length % 2 != 0) {
			middle = data.length / 2 + 1;
		} else {
			middle = data.length / 2;
		}
		int[] array = new int[middle];

		for (int i = 0; i < middle; i++) {
			array[i] = data[i];
		}
		return array;
	}

	private static int[] secondHalf(int[] data) {

		int middle = data.length / 2;
		int[] array = new int[middle];

		for (int i = 0; i < middle; i++) {
			array[i] = data[data.length - middle + i];
		}
		return array;
	}

	private static void merge(int[] data, int[] firstHalf, int[] secondHalf) {
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < firstHalf.length && rightIndex < secondHalf.length) {
			if (firstHalf[leftIndex] < secondHalf[rightIndex])
				data[index++] = firstHalf[leftIndex++];
			else {
				data[index++] = secondHalf[rightIndex++];
			}
		}
		while (leftIndex < firstHalf.length) {
			data[index++] = firstHalf[leftIndex++];
		}
		while (rightIndex < secondHalf.length) {
			data[index++] = secondHalf[rightIndex++];
		}
	}

	public static void mergeSort(int[] data) {

		if (data.length > 1) {
			int[] left = firstHalf(data);
			int[] right = secondHalf(data);
			mergeSort(left);
			mergeSort(right);
			merge(data, left, right);
		}

	}

	private static int partition(int[] data, int low, int high) {
		int temp;
		int midpoint = low + (high - low) / 2;
		int pivot = data[midpoint];

		boolean done = false;
		int l = low;
		int h = high;

		while (!done) {
			while (data[l] < pivot) {
				++l;
			}

			while (pivot < data[h]) {
				--h;
			}

			if (l >= h) {
				done = true;
			} else {
				temp = data[l];
				data[l] = data[h];
				data[h] = temp;

				++l;
				--h;
			}
		}
		return h;
	}

	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static void quickSort(int[] data, int low, int high) {

		int mid;

		if (low >= high) {
			return;
		}

		mid = partition(data, low, high);

		quickSort(data, low, mid);
		quickSort(data, mid + 1, high);
	}

}
