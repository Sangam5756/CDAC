/**
 * Class shows how to perform bubble sort.
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 5, 3, 8, 4, 2 };
		int n = arr.length;

		boolean flag = false;
		// no of passes
		for (int i = 0; i < n - 1; i++) {
			flag = false; // remember to reset the flag.
			// comparisons
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true; // swapped - hence true.
				}
			}
			if (!flag) {
				break;
			}
		}

		// display all elements.
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

}
