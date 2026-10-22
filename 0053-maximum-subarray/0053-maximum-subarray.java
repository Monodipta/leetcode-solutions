class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=nums[0];
        int bestSum=nums[0];

        for(int i=1;i<nums.length;i++){
            currentSum=Math.max(nums[i], currentSum+nums[i]);
            bestSum=Math.max(bestSum,currentSum);
        }
        return bestSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna