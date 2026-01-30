package sorting;

/**
 * This version uses 2 arrays for merging.
 *
 */
public class MergeSortTwo {

	public static void main(String[] args) {
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("After merge : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			mergeArray(arr, left, mid, right);
		}
	}

	//Like merging 2 sorted arrays.
	private static void mergeArray(int arr[], int left, int mid, int right) {
		int n1 = mid-left+1;
		int n2 = right- mid;
		
		//Create 2 arrays using left,mid,right.
		int one[] = new int[n1];
		int two[] = new int[n2];
		
		//Copy contents into first array
		for(int i = 0 ; i < n1;i++) {
			one[i] = arr[left + i];
		}
		
		//Copy contents into second array
		for(int j = 0 ; j < n2;j++) {
			two[j] = arr[mid+1+j];
		}
		
		int i = 0 ; int j = 0; int k = left;
		while( i< n1 && j < n2) {
			if(one[i] < two[j]) {
				arr[k++] = one[i++];
			}else {
				arr[k++] = two[j++];
			}
		}
		while(i < n1) {
			arr[k++] = one[i++];
		}
		while(j < n2) {
			arr[k++] = two[j++];
		}
		
	}

}
