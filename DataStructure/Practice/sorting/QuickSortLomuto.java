package sorting;

/**
 * Uses the Lomuto partition technique
 *
 */
public class QuickSortLomuto {
	
	public static void main(String[] args) {
		int input[] = {6,8,4,2,7,3,1,5};
		quickSort(input, 0, input.length-1);
		System.out.println("Sorted array:");
        for (int num : input) {
            System.out.print(num + " ");
        }
	}
	
	public static void quickSort(int arr[] , int low, int high) {
		if(low >=high) return;
		int partition = findPartition(arr,low,high);
		quickSort(arr,low,partition-1);
		quickSort(arr,partition+1,high);
	}
	
	private static int findPartition(int arr[], int low,int high) {
		int pivot = arr[high];
		int storeIndex = low - 1 ;
		for(int i = low ; i < high ; i++) {
			if(arr[i] < pivot) {
				storeIndex++;
				swap(arr,storeIndex,i); // 
			}
		}
		swap(arr,storeIndex+1,high);
		return storeIndex+1;
		
	}
	
	private static void swap(int arr[], int index1 , int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
