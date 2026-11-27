class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];

        for(String str:strs){

            int zerosCount=0;
            int onesCount=0;

            for(char ch : str.toCharArray()){
                if(ch == '0'){
                    zerosCount++;
                }else{
                    onesCount++;
                }
            }

            for(int z=m;z>=zerosCount;z--){
                for(int o=n;o>=onesCount;o--){
                    dp[z][o]=Math.max(dp[z][o],1+dp[z-zerosCount][o-onesCount]);
                }
            }
        }
        return dp[m][n];

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna