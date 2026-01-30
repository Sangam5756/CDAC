/**
 * Code for binary search.
 *
 */

public class BinarySeach {

	public static void main(String[] args) {

		int arr[] = { 20,30,50,70 };
		int target = 50;

		int targetIndex = binarySearch(arr, target);
		System.out.println("Found at " + targetIndex);
	}

	private static int binarySearch(int[] arr, int target) {

		int left = 0; // 0
		int right = arr.length - 1; // 0

		while (left <= right) { // Notice =
			int mid = (left + right) / 2;

			if (arr[mid] == target) { //Found
				return mid;
			}

			if (arr[mid] > target) {  // Find in left half.
				right = mid - 1;
			} else {
				left = mid + 1; //Find in right half.
			}
		}
		return -1;
	}

}
