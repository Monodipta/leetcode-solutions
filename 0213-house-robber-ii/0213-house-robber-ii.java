class Solution {
    public int rob(int[] nums) {
        int n=nums.length;

        if(n==1){
            return nums[0];
        }

        int case1=robRange(nums,0,n-2);
        int case2=robRange(nums,1,n-1);

        return Math.max(case1,case2);
    }

    private static int robRange(int[] nums,int start,int end){
    int len = end - start + 1;
    if (len == 1) {
            return nums[start];
        }
    int[] dp=new int[len];
    dp[0]=nums[start];
    dp[1]=Math.max(nums[start],nums[start+1]);

    for(int i=2;i<len;i++){
        int robCurrent=nums[start+i]+dp[i-2];
        int skipCurrent=dp[i-1];
        dp[i]=Math.max(robCurrent,skipCurrent);
    }
    return dp[len-1];

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna