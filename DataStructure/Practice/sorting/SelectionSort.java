/**
 * Code for selection sort.
 *
 */

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11, 90 };
		int noOfElements = arr.length;

		for (int i = 0; i < noOfElements - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < noOfElements; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j; // no swap, find index of minimum element
				}
			}
			if (i != minIndex) {
				swap(arr, i, minIndex);
			}
		}

		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

	private static void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
