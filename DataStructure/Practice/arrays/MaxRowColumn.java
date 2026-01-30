/**
 * Find the index of the row and column that contains max sum.
 * @author HP
 *
 */
public class MaxRowColumn {

	public static int[] findMaxRowAndColumn(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Find row with maximum sum
		int maxRowSum = Integer.MIN_VALUE;
		int maxRowIndex = 0;

		for (int i = 0; i < rows; i++) {
			int rowSum = 0;

			// Calculate sum of current row
			for (int j = 0; j < cols; j++) {
				rowSum += matrix[i][j];
			}

			// Update max if current row sum is greater
			if (rowSum > maxRowSum) {
				maxRowSum = rowSum;
				maxRowIndex = i;
			}
		}

		// Find column with maximum sum
		int maxColSum = Integer.MIN_VALUE;
		int maxColIndex = 0;

		for (int j = 0; j < cols; j++) {
			int colSum = 0;

			// Calculate sum of current column
			for (int i = 0; i < rows; i++) {
				colSum += matrix[i][j];
			}

			// Update max if current column sum is greater
			if (colSum > maxColSum) {
				maxColSum = colSum;
				maxColIndex = j;
			}
		}

		return new int[] { maxRowIndex, maxColIndex };
	}

	// Helper method to print matrix with sums
	private static void printMatrixWithSums(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		System.out.println("Matrix:");
		for (int i = 0; i < rows; i++) {
			int rowSum = 0;
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
				rowSum += matrix[i][j];
			}
			System.out.println(" | Row " + i + " sum: " + rowSum);
		}

		System.out.print("---");
		for (int j = 0; j < cols; j++)
			System.out.print("---");
		System.out.println();

		System.out.print("Col sums: ");
		for (int j = 0; j < cols; j++) {
			int colSum = 0;
			for (int i = 0; i < rows; i++) {
				colSum += matrix[i][j];
			}
			System.out.print(colSum + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Test Case 1
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Test Case 1:");
		printMatrixWithSums(matrix1);
		int[] result1 = findMaxRowAndColumn(matrix1);
		System.out.println("Max Row Index: " + result1[0]);
		System.out.println("Max Col Index: " + result1[1]);
		// Output: Max Row = 2, Max Col = 2

		// Test Case 2
		int[][] matrix2 = { { 3, 7, 2 }, { 9, 1, 8 } };

		System.out.println("\n\nTest Case 2:");
		printMatrixWithSums(matrix2);
		int[] result2 = findMaxRowAndColumn(matrix2);
		System.out.println("Max Row Index: " + result2[0]);
		System.out.println("Max Col Index: " + result2[1]);
		// Output: Max Row = 1, Max Col = 0
	}
}