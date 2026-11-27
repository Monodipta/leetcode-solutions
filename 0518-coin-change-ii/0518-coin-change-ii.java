class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];

        dp[0]=1;

        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                dp[j]+=dp[j-coin];
            }
        }
        return dp[amount];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna