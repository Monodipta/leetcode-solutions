class Solution {
    public boolean canPartition(int[] nums) {
      int totalSum=0;

      for(int num:nums){
        totalSum+=num;
      }  
      if(totalSum % 2 != 0){
        return false;
      }

      int target = totalSum/2;

      boolean[] dp=new boolean[target+1];

      dp[0]=true;

      for(int num:nums){
        for(int j=target;j>=num;j--){
            dp[j]=dp[j] || dp[j-num];
        }
      }
      return dp[target];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna