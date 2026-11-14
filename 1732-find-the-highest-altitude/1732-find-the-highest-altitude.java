class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude=0;

        int[] result=new int[gain.length+1];
              
        result[0]=0;
        for(int i=1;i<gain.length+1;i++){
            result[i]=result[i-1]+gain[i-1];

            if(maxAltitude<result[i]){
                maxAltitude=result[i];
            }
        }
        return maxAltitude;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna