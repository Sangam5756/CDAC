package recursion;

public class BinarySearchUsingRecursion {
	
	public static void main(String[] args) {
		int arr [] = {2,43,66,78,90,98};
		System.out.println("Found at index : "+binarySearch(78,arr));
	}
	
	public static int binarySearch(int target, int [] arr) {
		int result = binarySearchUsingRecursion(target,arr,0,arr.length-1);
		return result;
	}
	
	public static int binarySearchUsingRecursion(int target,int []arr,int left,int right) {
		if(left >right) return -1;
		
		int mid = left + (right-left)/2;
		
		if(arr[mid] == target) {
			return mid;	
		}else if(arr[mid] > target) {
			return binarySearchUsingRecursion(target,arr,left,mid-1);
		}else {
			return binarySearchUsingRecursion(target,arr,mid+1,right);		
		}
	}
	

}
