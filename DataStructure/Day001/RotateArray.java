/*
 * Rotate Array Right by k Positions
 * ----------------------------------------
 * Statement : Given an array and a number k, rotate the array to the right by k
 * steps.
 * 
 * Note: k can be larger than array length.
 * -----------------------------------------
 * 
 * arr = [1, 2, 3, 4, 5], k = 2
 * Result: [4, 5, 1, 2, 3]
 * 
 * -----------------------------------------
 * 
 * Hint:
 * 
 * Step 1: Reverse entire array
 * [1, 2, 3, 4, 5] → [5, 4, 3, 2, 1]
 * 
 * Step 2: Reverse first k=2 elements
 * [5, 4, 3, 2, 1] → [4, 5, 3, 2, 1]
 * └─┘
 * 
 * Step 3: Reverse remaining n-k=3 elements
 * [4, 5, 3, 2, 1] → [4, 5, 1, 2, 3]
 * └─────┘
 * 
 * 
 * 
 * Why k % n?
 * If arr = [1, 2, 3], k = 5
 * Rotating by 5 is same as rotating by 5 % 3 = 2
 * Because after 3 rotations, array returns to original state
 * 
 * Complexity Analysis
 * Time Complexity: O(n)
 * 
 * Each reversal is O(n) in worst case
 * Three reversals: O(n) + O(k) + O(n-k) = O(n)
 * 
 * Space Complexity: O(1)
 * 
 * Only constant extra variables
 * All operations in-place
 */

public class RotateArray {

    public static void reverse(int arr[], int i, int j) {

        // in swap we can use two pointer approach
        int left = i;
        int right = j;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;

        }
    }

    public static void rotateArray(int arr[], int k) {

        int n = arr.length;
        k = k % n;

        // int temp[] = new int[k-1];
        // int index = 0;
        // for (int i = n - k+1; i < n; i++) {

        // temp[index++] = arr[i];
        // }

        for (int i = n - 1; i >= k; i--) {
            arr[i] = arr[i - k];
        }
        // for(int i=0; i<k;i++){
        // arr[i] = temp[i];
        // }

        printArr(arr);

    }

    public static void rotateArray2(int arr[], int k) {

        int n = arr.length - 1;
        // first find n-k to n into tep
        k = k % n;

        // reverse the first element till k
        printArr(arr);
        System.out.println();
        reverse(arr, 0, k);
        printArr(arr);
        System.out.println();

        reverse(arr, k + 1, n);
        printArr(arr);
        System.out.println();

        reverse(arr, 0, n);
        printArr(arr);
        System.out.println();

    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        rotateArray(arr, 3);
    }

}