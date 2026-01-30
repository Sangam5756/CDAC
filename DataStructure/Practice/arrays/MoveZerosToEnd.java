class MoveZerosToEnd {

	public static void main(String args[]) {

		int arr[] = new int[] { 16, 0, 8, 4, 2, 0, 1 };
		int n = arr.length;

		int writeIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				swap(arr, i, writeIndex);
				writeIndex++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}