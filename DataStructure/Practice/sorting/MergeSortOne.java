package sorting;

import java.util.Arrays;

/**
 * This version of merge sort uses 1 new array for merging.
 *
 */
public class MergeSortOne {
	
	public static void main(String[] args) {
		int arr[] = {38,27,43,3,9,82,10};
		int temp[] = new int[arr.length]; // This one.
		mergeSort(arr, 0, arr.length - 1 , temp );
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//Divide and Conquer.
	public static void mergeSort(int arr[], int left, int right, int []temp) {
		if(left < right ) {
			int mid = left + (right - left )/2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			mergeArray(arr,left, mid, right,temp);
		}
	}
	
	//Merge 2 arrays - Imagine the temp array as 2 arrays -  we play with indexes.
	private static void mergeArray(int arr[], int left, int mid,int right, int[]temp) {
		System.out.println("Left is : " + left + " and right is: " +right);
		System.arraycopy(arr, left, temp, left, right-left+1);
		
		System.out.println("Showing temp array:");
		System.out.println(Arrays.toString(temp));
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i<=mid && j <=right) {
			arr[k++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
		}
		
		while( i <= mid) {
			arr[k++] = temp[i++];	
		}
		
		while( j <= right) {
			arr[k++] = temp[j++];	
		}
		
		System.out.println("Showing original array after partial sort:");
		System.out.println(Arrays.toString(arr));
		
	}
	

}
