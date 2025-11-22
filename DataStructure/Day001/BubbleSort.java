/*
 * Bubble Sort
 * ------------------
 * Statement : You are given a list of integers. Your task is to sort the list
 * in ascending order using
 * the Bubble Sort algorithm
 * --------------------------------
 * 
 * Example 1:
 * 
 * Input: 5 2 9 1 5
 * Output : 1 2 5 5 9
 * 
 * -------------------
 * Example 2 :
 * Input : 10 3 8 4 2 7
 * Output : 2 3 4 7 8 10
 * 
 * Note : Stop early if the array is already sorted ( no elements are swapped)
 * 
 */

public class BubbleSort {

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void main(String[] args) {

        int arr[] = {
                5, 4, 3, 2, 1
        };
        printArr(arr);
        System.out.println();
        bubbleSort(arr);
        printArr(arr);

    }
}