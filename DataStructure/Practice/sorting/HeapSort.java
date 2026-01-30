package sorting;

public class HeapSort {
	
	public static void main(String[] args) {
		int arr[] = {6,8,4,2,7,3,1,5};
		heapSort(arr);
		for(int element : arr) {
			System.out.print(element + " ");
		}
	}
	
	private static void heapSort(int arr[]) {
		int n = arr.length;
		//Step 1 : Heapify on non-leaves
		for(int i = n/2-1 ; i >=0;i--) {
			heapify(arr, n , i);	
		}
		
		//Step 2 : Max heap gives us largest at index 0.
		for(int i = n-1; i > 0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
		
	}
	
	private static void heapify(int arr[], int heapSize, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2 *i+2;
		
		if( left < heapSize  && arr[left]  > arr[largest]) {
			largest = left;
		}
		
		if( right < heapSize  && arr[right]  > arr[largest]) {
			largest = right;
		}
		
		if( i != largest) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr,heapSize,largest);
		}
		
	}

}
