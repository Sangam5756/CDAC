public class RotateMatrix90 {
    
    public static void rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // Upper triangle only
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix, i);
        }
    }
    
    // Helper method to reverse a specific row
    private static void reverseRow(int[][] matrix, int row) {
        int left = 0;
        int right = matrix[row].length - 1;
        
        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }
    
    // Helper method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Test Case 1:");
        System.out.println("Before rotation:");
        printMatrix(matrix1);
        
        rotate90Clockwise(matrix1);
        
        System.out.println("\nAfter 90Â° clockwise rotation:");
        printMatrix(matrix1);
        // Output:
        // 7 4 1
        // 8 5 2
        // 9 6 3
        
        // Test Case 2
        int[][] matrix2 = {
            {1, 2},
            {3, 4}
        };
        
        System.out.println("\n\nTest Case 2:");
        System.out.println("Before rotation:");
        printMatrix(matrix2);
        
        rotate90Clockwise(matrix2);
        
        System.out.println("\nAfter 90° clockwise rotation:");
        printMatrix(matrix2);
        // Output:
        // 3 1
        // 4 2
    }
}