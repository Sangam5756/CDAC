/*
 * Find Row and Column with Maximum Sum
 * -------------------------------------
 * Statement : Given a 2D matrix, find –
 * 1. The row with the maximum sum
 * 2. The column with the maximum sum. Return their indices (0-based).
 * 
 * ----------------------------------------------------------------------
 * Example 1:**
 * 
 * Input: matrix = [
 * [1, 2, 3], // Row 0: sum = 6
 * [4, 5, 6], // Row 1: sum = 15
 * [7, 8, 9] // Row 2: sum = 24 (max row)
 * ]
 * // Column sums: 12, 15, 18 (Column 2 is max)
 * 
 * Output: maxRow = 2, maxCol = 2
 * ----------------------------------------------
 *
 * Example 2:**
 * 
 * Input: matrix = [
 * [3, 7, 2], // Row 0: sum = 12
 * [9, 1, 8] // Row 1: sum = 18 (max row)
 * ]
 * // Column sums: 12, 8, 10 (Column 0 is max)
 * 
 * Output: maxRow = 1, maxCol = 0
 * -----------------------------------------------
 * 
 * ### Approach
 * 1. Calculate sum for each row, track maximum
 * 2. Calculate sum for each column, track maximum
 * 3. Return indices of maximum row and column
 */





public class row_col_max_sum {

    public static int rowColMaxSum(int[][] arr) {

        // matrix length
        int row = -1;
        int col = -1;
        int rowmax = Integer.MIN_VALUE;
        int rowSum = 0;
        int colMax = Integer.MIN_VALUE;
        int colSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // traverse col
            rowSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                rowSum += arr[i][j]; // sum is taken
                colSum += arr[j][i];
            }
            if (colMax < colSum) {
                colMax = colSum;
                col = i;
            }
            // here we got the sum lets check
            if (rowmax < rowSum) {
                rowmax = rowSum;
                row = i;
            }

        }
        System.out.println(row);
        System.out.println(col);
        return row;
    }

    public static void main(String[] args) {

        int arr[][] = {
                { 1, 13, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        rowColMaxSum(arr);
    }
}
