class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle empty matrix edge cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Start at the top-right corner
        int row = 0;
        int col = n - 1;
        
        // Stay within the boundaries of the matrix
        while (row < m && col >= 0) {
            int current = matrix[row][col];
            
            if (current == target) {
                return true; // Found the target
            } else if (current > target) {
                col--; // Target is smaller, look to the left
            } else {
                row++; // Target is larger, look below
            }
        }
        
        return false; // Target not found
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna