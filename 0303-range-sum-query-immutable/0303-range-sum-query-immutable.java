class NumArray {
private int[] prefixSums;

    // 1. This is the setup step (Constructor)
    public NumArray(int[] nums) {
        // We make the prefix array 1 element larger to easily handle index 0
        prefixSums = new int[nums.length + 1];
        
        // Calculate the running totals
        prefixSums[0] = 0; 
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    // 2. This is the action button that calculates the range sum instantly
    public int sumRange(int left, int right) {
        // Instead of a loop, we just do one subtraction step
        return prefixSums[right + 1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna