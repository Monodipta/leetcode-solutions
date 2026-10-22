class Solution {
    public int[] runningSum(int[] nums) {
        if( 1 > nums.length || nums.length > 1000){
            throw new IllegalArgumentException("nums length not with in the range");
        }
        for(int num : nums){
            if(-1000000 > num || num > 1000000 ){
                throw new IllegalArgumentException("num not with in the range");
            }
        }
        int prefix[]= new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i< nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        return prefix;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna