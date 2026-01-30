import java.util.Arrays;

public class RotateArray {
    
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        
        // Handle case when k > n
        k = k % n;
        
        // If k is 0, no rotation needed
        if (k == 0) return;
        
        // Step 1: Reverse entire array
        reverse(arr, 0, n - 1);
        
        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);
        
        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }
    
    // Helper method to reverse array from start to end index
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(arr1));
        rotate(arr1, 2);
        System.out.println("After rotating 2 times:  " + Arrays.toString(arr1));
        // Output: [4, 5, 1, 2, 3]
        
        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\nBefore: " + Arrays.toString(arr2));
        rotate(arr2, 3);
        System.out.println("After rotating 3 times:  " + Arrays.toString(arr2));
        // Output: [5, 6, 7, 1, 2, 3, 4]
    }
}