/*
 * Example 1:
 * ------------------
 * Input: matrix = [
 * [1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]
 * ]
 * 
 * Output: matrix = [
 * [7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3]
 * ]
 * 
 * Visualization:
 * 1 2 3 7 4 1
 * 4 5 6 → 8 5 2
 * 7 8 9 9 6 3
 * -------------------
 * Example 2:
 * -------------------
 * Input: matrix = [
 * [1, 2],
 * [3, 4]
 * ]
 * 
 * Output: matrix = [
 * [3, 1],
 * [4, 2]
 * ]
 * 
 * Approach
 * -----------
 * Two-step process:
 * 
 * Transpose the matrix (convert rows to columns)
 * Reverse each row
 * 
 * --------------------
 * Complexity Analysis
 * Time Complexity: O(n²)
 * 
 * Transpose: O(n²/2) for upper triangle
 * Reverse rows: O(n) per row × n rows = O(n²)
 * Total: O(n²)
 * 
 * Space Complexity: O(1)
 * 
 * Only constant extra variables
 * All operations in-place
 * No additional matrix created
 */

public class TransposeMatrix {

    public static void transpose(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = arr[i][j];
            }
        }
    }

    public static void printArr(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        transpose(arr);
        printArr(arr);
    }
}
