public class TransposeMatrix {
    
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        
        // Iterate through upper triangle only
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // j starts from i+1
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    // Helper method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Before:");
        printMatrix(matrix1);
        transpose(matrix1);
        System.out.println("\nAfter:");
        printMatrix(matrix1);
        // Output:
        // [1, 4, 7]
        // [2, 5, 8]
        // [3, 6, 9]
        
        // Test Case 2
        int[][] matrix2 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("\n\nBefore:");
        printMatrix(matrix2);
        transpose(matrix2);
        System.out.println("\nAfter:");
        printMatrix(matrix2);
        // Output:
        // [1, 3]
        // [2, 4]
    }
}