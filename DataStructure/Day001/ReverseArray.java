/*
 * Problem 1 : Reverse Array In-Place
 * ----------------------------------
 * Statement : Given an integer array, reverse it in-place (without using extra
 * space for another array).
 * ----------------------------------
 * arr = [1, 2, 3, 4, 5]
 * 
 * Step 1: left=0, right=4
 * [1, 2, 3, 4, 5]
 * ↑ ↑
 * L R
 * Swap: [5, 2, 3, 4, 1]
 * 
 * Step 2: left=1, right=3
 * [5, 2, 3, 4, 1]
 * ↑ ↑
 * L R
 * Swap: [5, 4, 3, 2, 1]
 * 
 * Step 3: left=2, right=2
 * [5, 4, 3, 2, 1]
 * ↑
 * L,R
 * Stop (left not < right)
 * 
 * Result: [5, 4, 3, 2, 1]
 * 
 * -----------------------
 * Time Complexity: O(n)
 * 
 * We visit each element once
 * n/2 swaps for array of size n
 * O(n/2) = O(n)
 * 
 * Space Complexity: O(1)
 * 
 * Only use constant extra space (temp, left, right variables)
 * No additional arrays created
 * True in-place algorithm
 */

public class ReverseArray{

    public static void swap(int arr[]){

        // in swap we can use two pointer approach
        int left = 0;
        int right = arr.length-1;

        while(left < right){

            int temp = arr[left];
            arr[left] =arr[right];
            arr[right] = temp;


            left++;
            right--;


        }
    }

    public static void printArr(int[]arr){
        for(int i :arr){
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) {
                
        int arr [] = {1,2,3,4,5};
printArr(arr);
        swap(arr);
        System.out.println();
        printArr(arr);
    }

}