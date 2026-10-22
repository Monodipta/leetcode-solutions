class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid window size");
        }
        
        // Use a long or int to keep track of the sum of the current window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        // Track the maximum sum we have seen so far
        int maxSum = windowSum;
        
        // Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // CRITICAL FIX: Convert maxSum to a double before dividing by k
        // This forces Java to do floating-point division and keep the decimals!
        return (double) maxSum / k;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna