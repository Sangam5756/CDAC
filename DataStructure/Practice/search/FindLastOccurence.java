
//Sorted array with duplicates, find last occurrence.
public class FindLastOccurence {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 5 };
		int target = 2;
		int result = findLastOccurence(arr, target);
		System.out.println("Target at index: " + result);
	}

	private static int findLastOccurence(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1; // not found

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				result = mid;
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

}
